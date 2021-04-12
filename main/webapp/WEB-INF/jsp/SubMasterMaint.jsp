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
<form action="${fu}mastSubMaint" method="get">
<c:catch var="exception">${SubjectData.subjectId}</c:catch>
<c:choose>
<c:when test="${not empty exception}">
Subject ID <input type="text" name="subjectId">
Subject Name <input type="text" name="subjectName">
</c:when>
<c:when test="${empty exception}">
Subject ID <input type="text" name="subjectId" value='${SubjectData.subjectId}'>
Subject Name <input type="text" name="subjectName" value='${SubjectData.subjectName}'>
</c:when>
</c:choose>
<button type="submit" name="submit">Submit</button>
</form>
</body>
</html>