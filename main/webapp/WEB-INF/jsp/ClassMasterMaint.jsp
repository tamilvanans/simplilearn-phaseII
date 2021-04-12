<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="Header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${fu}mastClassMaint" method="get">
<c:catch var="exception">${ClassData.classId}</c:catch>
<c:choose>
<c:when test="${not empty exception}">
Class ID <input type="text" name="classId">
Class Description <input type="text" name="classDesc">
</c:when>
<c:when test="${empty exception}">
Class ID <input type="text" name="classId" value='${ClassData.classId}'>
Class Description <input type="text" name="classDesc" value='${ClassData.classDesc}'>
</c:when>
</c:choose>	
<button type="submit" name="submit">Submit</button>
</form>
</body>
</html>