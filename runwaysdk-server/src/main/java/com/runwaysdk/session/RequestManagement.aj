/*******************************************************************************
 * Copyright (c) 2013 TerraFrame, Inc. All rights reserved. 
 * 
 * This file is part of Runway SDK(tm).
 * 
 * Runway SDK(tm) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * Runway SDK(tm) is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Runway SDK(tm).  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.runwaysdk.session;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.runwaysdk.AttributeNotification;
import com.runwaysdk.CommonExceptionMessageLocalizer;
import com.runwaysdk.MessageExceptionDTO;
import com.runwaysdk.ProblemException;
import com.runwaysdk.ProblemExceptionDTO;
import com.runwaysdk.ProblemIF;
import com.runwaysdk.RunwayException;
import com.runwaysdk.RunwayExceptionDTO;
import com.runwaysdk.RunwayExceptionIF;
import com.runwaysdk.RunwayProblem;
import com.runwaysdk.business.BusinessFacade;
import com.runwaysdk.business.ComponentDTOFacade;
import com.runwaysdk.business.ExceptionDTO;
import com.runwaysdk.business.Information;
import com.runwaysdk.business.InformationDTO;
import com.runwaysdk.business.Message;
import com.runwaysdk.business.MessageDTO;
import com.runwaysdk.business.Problem;
import com.runwaysdk.business.ProblemDTOIF;
import com.runwaysdk.business.SmartException;
import com.runwaysdk.business.Warning;
import com.runwaysdk.business.WarningDTO;
import com.runwaysdk.business.rbac.RoleDAOIF;
import com.runwaysdk.constants.ClientRequestIF;
import com.runwaysdk.dataaccess.ProgrammingErrorException;
import com.runwaysdk.dataaccess.transaction.LockObject;
import com.runwaysdk.logging.RunwayLogUtil;
import com.runwaysdk.transport.conversion.RunwayProblemToRunwayProblemDTO;
import com.runwaysdk.transport.conversion.business.InformationToInformationDTO;
import com.runwaysdk.transport.conversion.business.ProblemToProblemDTO;
import com.runwaysdk.transport.conversion.business.SmartExceptionToExceptionDTO;
import com.runwaysdk.transport.conversion.business.WarningToWarningDTO;

public aspect RequestManagement extends AbstractRequestManagement
{

  public RequestManagement()
  {
    this.requestState                = new RequestState();
  }

  public pointcut request()
  : (nonThreadRequest() && !cflow(threadRequest(Request)));

//  public pointcut request(Request request)
//  : (nonThreadRequest(Request) && !cflow(threadRequest(Request)) && @annotation(request));

  public pointcut enterSession()
  : request();
//  : nonAnnotizedRequestEntryPoints() || request(Request);

  // Initialize session information
  Object around(String _sessionId) :  topLevelPermission(_sessionId)
  {
    this.messageList.clear();

    try
    {
      if (_sessionId == null || _sessionId.trim().equals("") || !SessionFacade.containsSession(_sessionId))
      {
        // throw an invalid session exception
        String errorMsg = "Session [" + _sessionId + "] does not exist or has expired.";

        throw new InvalidSessionException(errorMsg);
      }

      this.getRequestState().setSession(SessionFacade.getSessionForRequest(_sessionId));

      SessionFacade.renewSession(this.getRequestState().getSession().getId());

      Object returnObject = proceed(this.getRequestState().getSession().getId());

      if (messageList.size() > 0)
      {
        List<MessageDTO> messageDTOList = new LinkedList<MessageDTO>();
        List<WarningDTO> warningDTOList = new LinkedList<WarningDTO>();
        List<InformationDTO> informationDTOList = new LinkedList<InformationDTO>();

        for (Message message : messageList)
        {
          message.setLocale(this.getRequestState().getSession().getLocale());

          if (message instanceof Warning)
          {
            WarningToWarningDTO converter = new WarningToWarningDTO(this.getRequestState().getSession().getId(), (Warning) message, false);
            WarningDTO warningDTO = converter.populate();
            warningDTOList.add(warningDTO);
            messageDTOList.add(warningDTO);
          }
          else if (message instanceof Information)
          {
            InformationToInformationDTO converter = new InformationToInformationDTO(this.getRequestState().getSession().getId(), (Information) message, false);
            InformationDTO informationDTO = converter.populate();
            informationDTOList.add(informationDTO);
            messageDTOList.add(informationDTO);
          }
        }

        throw new MessageExceptionDTO(returnObject, messageDTOList, warningDTOList, informationDTOList);
      }

      return returnObject;
    }
    catch (InvalidSessionException isEx)
    {
      isEx.setLocale(Locale.getDefault());
      RunwayExceptionDTO runEx = new RunwayExceptionDTO(isEx.getClass().getName(), isEx.getLocalizedMessage(), isEx.getMessage());

      log.info(RunwayLogUtil.getExceptionLoggableMessage(runEx), runEx);

      throw runEx;
    }
    catch (Throwable ex)
    {
      if (ex instanceof MessageExceptionDTO)
      {
        log.info(RunwayLogUtil.getExceptionLoggableMessage(ex), ex);
        throw (MessageExceptionDTO) ex;
      }
      else
      {
        throw processException(ex, this.getRequestState().getSession().getLocale());
      }
    }
    finally
    {
    }
  }

  // Process any error message that occurs when logging in.
  Object around() :
    execution (* com.runwaysdk.facade.Facade.login(String, String, Locale[]))  ||
    execution (* com.runwaysdk.facade.Facade.loginUser(String, String))  ||
    execution (* com.runwaysdk.facade.Facade.logout(String))  ||
    execution (* com.runwaysdk.facade.Facade.changeLogin(String, String, String))
  {
    try
    {
      return proceed();
    }
    catch (Throwable ex)
    {
      throw processException(ex, Locale.getDefault());
    }
  }

  private RuntimeException processException(Throwable throwable, Locale locale)
  {
    Throwable ex = throwable;

    boolean isError = false;
    RuntimeException returnEx;

    if (ex instanceof InvocationTargetException)
    {
      InvocationTargetException invocationTargetException = (InvocationTargetException) ex;

      Throwable te = invocationTargetException.getTargetException();

      if (te instanceof RunwayExceptionIF)
      {
        ex = te;
      }
    }

    if (ex instanceof AttributeNotification)
    {
      AttributeNotification attributeNotification = (AttributeNotification) ex;
      // if a new instance has problems associated with it, restore the original
      // id that was sent to the server
      // from a client.
      if (this.idMap.containsKey(attributeNotification.getComponentId()))
      {
        attributeNotification.setComponentId(this.idMap.get(attributeNotification.getComponentId()));
      }
    }

    if (ex instanceof SmartException)
    {
      SmartException smartException = (SmartException) ex;
      BusinessFacade.setSmartExceptionLocale(smartException, locale);

      SmartExceptionToExceptionDTO converter = new SmartExceptionToExceptionDTO(this.getRequestState().getSession().getId(), smartException, false);
      ExceptionDTO exceptionDTO = converter.populate();

      returnEx = ComponentDTOFacade.newSmartExceptionDTO(exceptionDTO);
    }
    else if (ex instanceof ProblemException)
    {
      ProblemException problemException = (ProblemException) ex;
      List<ProblemDTOIF> problemDTOIFList = new LinkedList<ProblemDTOIF>();

      for (ProblemIF problemIF : problemException.getProblems())
      {
        if (problemIF instanceof AttributeNotification)
        {
          AttributeNotification attributeNotification = (AttributeNotification) problemIF;
          // if a new instance has problems associated with it, restore the
          // original id that was sent to the server
          // from a client.
          if (this.idMap.containsKey(attributeNotification.getComponentId()))
          {
            attributeNotification.setComponentId(this.idMap.get(attributeNotification.getComponentId()));
          }
        }

        problemIF.setLocale(locale);

        ProblemDTOIF problemDTOIF = null;

        if (problemIF instanceof Problem)
        {
          ProblemToProblemDTO converter = new ProblemToProblemDTO(this.getRequestState().getSession().getId(), (Problem) problemIF, false);
          problemDTOIF = converter.populate();
        }
        else
        {
          RunwayProblemToRunwayProblemDTO converter = RunwayProblemToRunwayProblemDTO.getConverter((RunwayProblem) problemIF);
          problemDTOIF = converter.populate();
        }
        if (this.getRequestState().getSession() != null && !this.getRequestState().getSession().userHasRole(RoleDAOIF.DEVELOPER_ROLE))
        {
          problemDTOIF.setDeveloperMessage("");
        }
        problemDTOIFList.add(problemDTOIF);
      }

      problemException.setLocale(locale);

      returnEx = new ProblemExceptionDTO(problemException.getLocalizedMessage(), problemDTOIFList);
    }
    else if (ex instanceof RunwayException)
    {
      RunwayException fwEx = ( (RunwayException) ex );
      isError = fwEx instanceof ProgrammingErrorException; // special case to capture abnormal errors
      
      fwEx.setLocale(locale);

      String developerMessage;

      if (this.getRequestState().getSession() != null && this.getRequestState().getSession().userHasRole(RoleDAOIF.DEVELOPER_ROLE))
      {
        Writer result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        fwEx.printStackTrace(printWriter);
        developerMessage = result.toString();
      }
      else
      {
        developerMessage = "";
      }

      returnEx = new RunwayExceptionDTO(fwEx.getClass().getName(), fwEx.getLocalizedMessage(), developerMessage);
    }
    // If a runway exception was not thrown, then most likely a programming
    // error occurred.
    else
    {
      String developerMessage = "";

      if (this.getRequestState().getSession() != null && this.getRequestState().getSession().userHasRole(RoleDAOIF.DEVELOPER_ROLE))
      {
        Writer result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        ex.printStackTrace(printWriter);
        developerMessage = result.toString();
      }

      // This exception will notify developers/administrators that
      // a serious problem occurred.
      ProgrammingErrorException programmingErrorException = new ProgrammingErrorException(ex);
      programmingErrorException.setStackTrace(ex.getStackTrace());
      isError = true;
      
      String errMessage = ClientRequestIF.ERROR_MSG_DELIMITER + programmingErrorException.getClass().getName() + ClientRequestIF.ERROR_MSG_DELIMITER + CommonExceptionMessageLocalizer.runwayException(locale) + ClientRequestIF.ERROR_MSG_DELIMITER + developerMessage + ClientRequestIF.ERROR_MSG_DELIMITER;

      returnEx = new RuntimeException(errMessage);
    }
    
    if(isError)
    {
      log.error(RunwayLogUtil.getExceptionLoggableMessage(ex), ex);
    }
    else
    {
      log.info(RunwayLogUtil.getExceptionLoggableMessage(ex), ex);
    }
    
    return returnEx;
  }


  after() returning : topLevelSession()
  {
    try
    {
      if (this.getRequestState().getSession() != null)
      {
        ( (Session) this.getRequestState().getSession() ).setFirstMdMethodDAOIF(null);
        if (this.getRequestState().getSession().closeOnEndOfRequest())
        {
          SessionFacade.closeSession(this.getRequestState().getSession().getId());

        }
        
      }

      this.getRequestState().commitAndCloseConnection(thisJoinPoint);
    }
    finally
    {
      ( LockObject.getLockObject() ).releaseAppLocks(setAppLocksSet);
      setAppLocksSet.clear();

      this.idMap.clear();
      
      this.getRequestState().setSession(null);
    }
  }

  after() throwing : topLevelSession()
  {
    try
    {
      if (this.getRequestState().getSession() != null)
      {
        ( (Session) this.getRequestState().getSession() ).setFirstMdMethodDAOIF(null);
        SessionFacade.endOfRequest(this.getRequestState().getSession().getId());
        
      }

      this.getRequestState().rollbackAndCloseConnection(thisJoinPoint);
    }
    finally
    {
      ( LockObject.getLockObject() ).releaseAppLocks(setAppLocksSet);
      setAppLocksSet.clear();

      this.idMap.clear();
      
      this.getRequestState().setSession(null);
    }
  }
}
