<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/SchoolApp/mastStudMaint" method="get">
<c:catch var="exception">${StudentData.studentId}</c:catch>
<c:choose>
<c:when test="${not empty exception}">
Roll No <input type="text" name="rollNo">
Student Name <input type="text" name="studName">
</c:when>
<c:when test="${empty exception}">
<c:catch var="exception">${StudentData.studentId}</c:catch>
Roll No <input type="text" name="rollNo" value='${StudentData.studentId}'>
Student Name <input type="text" name="studName" value='${StudentData.studentName}'>
</c:when>
</c:choose>
<button type="submit" name="submit">Submit</button>
</form>
</body>
</html>