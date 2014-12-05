package com.runwaysdk.system.scheduler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.runwaysdk.logging.LogLevel;
import com.runwaysdk.logging.RunwayLogUtil;
import com.runwaysdk.session.Request;
import com.runwaysdk.util.IDGenerator;

public abstract class ExecutableJob extends ExecutableJobBase implements org.quartz.Job, com.runwaysdk.system.scheduler.Job, ExecutableJobIF
{
  private static final long        serialVersionUID = 328266996;

  private Map<String, JobListener> listeners;
  
  private static final String JOB_ID_PREPEND = "_JOB_";

  public ExecutableJob()
  {
    super();
    
    this.listeners = new LinkedHashMap<String, JobListener>();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.business.Entity#buildKey()
   */
  @Override
  protected String buildKey()
  {
    return this.getJobId();
  }

  /**
   * 
   * @param jobListener
   */
  public void addJobListener(JobListener jobListener)
  {
    this.listeners.put(jobListener.getName(), jobListener);
  }

  /**
   * 
   * @return
   */
  public Map<String, JobListener> getJobListeners()
  {
    return this.listeners;
  }

  /**
   * Executes the Job within the context of Quartz.
   */
  @Override
  @Request
  public final void execute(JobExecutionContext context) throws JobExecutionException
  {
    JobHistoryRecord record;
    ExecutableJob job;
    JobHistory history;
    
    String id = context.getJobDetail().getKey().getName();
    if (id.startsWith(JOB_ID_PREPEND))
    {
      id = id.replaceFirst(JOB_ID_PREPEND, "");
      
      job = ExecutableJob.get(id);
      
      history = new JobHistory();
      history.setStartTime(new Date());
      history.addStatus(AllJobStatus.RUNNING);
      history.apply();
      
      record = new JobHistoryRecord(job, history);
      record.apply();
    }
    else 
    {
      record = JobHistoryRecord.get(id);
      job = record.getParent();
      history = record.getChild();
    }

    ExecutionContext executionContext = ExecutionContext.factory(ExecutionContext.Context.EXECUTION, job, history);

    executeJob(job, history, executionContext);
  }

  /**
   * The final stage in executing the job, which invokes the execute() method
   * directly. This cannot be overridden because it follows a special error
   * handling procedure.
   * 
   * @param ej
   * @param executionContext
   */
  @Request
  static final void executeJob(ExecutableJob job, JobHistory history, ExecutionContext executionContext)
  {
    String errorMessage = null;

    try
    {
      job.execute(executionContext);
    }
    catch (Throwable t)
    {
      if (t.getCause() != null)
      {
        t = t.getCause();
      }

      errorMessage = t.getLocalizedMessage();

      if (errorMessage == null)
      {
        errorMessage = t.getMessage();
      }
    }

    JobHistory jh = JobHistory.get(history.getId());
    
    jh.appLock();
    jh.setEndTime(new Date());
    jh.clearStatus();
    if (errorMessage != null)
    {
      jh.getHistoryInformation().setValue(errorMessage);
      jh.addStatus(AllJobStatus.FAILURE);
    }
    else
    {
      jh.addStatus(AllJobStatus.SUCCESS);
    }
    jh.apply();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.system.scheduler.ExecutableJob#execute()
   */
  @Override
  public void execute(ExecutionContext executionContext)
  {
    // do nothing by default
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.system.scheduler.JobIF#getLocalizedDisplayLabel()
   */
  @Override
  public String getLocalizedDescription()
  {
    return this.getDescription().getValue();
  }

  public synchronized JobHistory start()
  {
    for (JobListener jobListener : this.listeners.values())
    {
      SchedulerManager.addJobListener(this, jobListener);
    }
    
    JobHistory jh = new JobHistory();
    jh.setStartTime(new Date());
    jh.addStatus(AllJobStatus.RUNNING);
    jh.apply();
    
    JobHistoryRecord rec = new JobHistoryRecord(this, jh);
    rec.apply();
    
    SchedulerManager.schedule(this, rec.getId());
    
    return jh;
  }

  @Request
  public void stop()
  {
    // TODO : Not supported yet.
  }

  @Request
  public void pause()
  {
    // TODO : Not supported yet.
  }

  @Request
  public void resume()
  {
    // TODO : Not supported yet.
  }

  @Request
  public void cancel()
  {
    // TODO : Not supported yet.
  }

  /**
   * 
   */
  @Override
  public void apply()
  {

    // If a job id is not set generate a unique id in its place.
    String jobId = this.getJobId();
    if (jobId == null || jobId.trim().length() == 0)
    {
      String id = IDGenerator.nextID();
      this.setJobId(id);
    }

    // Set the display label to the job id if one is not set already
    ExecutableJobDescription desc = this.getDescription();
    String value = desc.getDefaultValue();
    if (value == null || value.trim().length() == 0)
    {
      desc.setDefaultValue(this.getJobId());
    }

    super.apply();

    if (this.isModified(CRONEXPRESSION))
    {
      if (this.getCronExpression() != null && this.getCronExpression().length() > 0)
      {
        SchedulerManager.schedule(this, JOB_ID_PREPEND + this.getId(), this.getCronExpression());
      }
      else
      {
        SchedulerManager.remove(this, JOB_ID_PREPEND + this.getId());
      }
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.business.Element#delete()
   */
  @Override
  public void delete()
  {
    // Remove all scheduled jobs
    SchedulerManager.remove(this, JOB_ID_PREPEND + this.getId());

    super.delete();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.system.scheduler.JobBase#toString()
   */
  @Override
  public String toString()
  {
    String clazz = this.getClassDisplayLabel();
    String id = this.getJobId();
    String desc = this.getDescription().getValue();

    if (id != null && desc != null && id == desc)
    {
      return "[" + clazz + "] - " + desc;
    }
    else if (id != null && desc != null)
    {
      return "[" + clazz + "] - " + desc + " (" + id + ")";
    }
    else
    {
      return "[" + clazz + "] - " + this.getId();
    }
  }

}
