<%@ taglib uri="/WEB-INF/tlds/runwayLib.tld" prefix="mjl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="page_title" scope="request" value="View all MdLocalizable Message"/>
<mjl:table var="item" query="${query}">
  <mjl:context action="com.runwaysdk.system.metadata.MdLocalizableMessageController.viewPage.mojo" />
  <mjl:columns>
    <mjl:attributeColumn attributeName="d1_defaultLocale">
    </mjl:attributeColumn>
    <mjl:attributeColumn attributeName="d2_defaultLocale">
    </mjl:attributeColumn>
    <mjl:attributeColumn attributeName="defaultLocale">
    </mjl:attributeColumn>
    <mjl:freeColumn>
      <mjl:header>
        
      </mjl:header>
      <mjl:row>
        <mjl:commandLink name="view.link" action="com.runwaysdk.system.metadata.MdLocalizableMessageController.view.mojo">
          View
          <mjl:property name="id" value="${item.id}" />
        </mjl:commandLink>
      </mjl:row>
      <mjl:footer>
        
      </mjl:footer>
    </mjl:freeColumn>
  </mjl:columns>
  <mjl:pagination>
    <mjl:page />
  </mjl:pagination>
</mjl:table>
<br />
<mjl:commandLink name="MdLocalizableMessageController.newInstance" action="com.runwaysdk.system.metadata.MdLocalizableMessageController.newInstance.mojo">
  Create a new MdLocalizable Message
</mjl:commandLink>
