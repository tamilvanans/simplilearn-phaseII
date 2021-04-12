 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval expression="@environment.getProperty('server.servlet.context-path')" var="frontendUrl" />  
<script>
var fu ="${frontendUrl}";
</script> 
