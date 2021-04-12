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
<form action="/SchoolApp/mastStaffMaint" method="get">
<c:catch var="exception">${TeacherData.staffId}</c:catch>
<c:choose>
<c:when test="${not empty exception}">
Emp ID <input type="text" name="staffId">
Staff Name <input type="text" name="staffName">
</c:when>
<c:when test="${empty exception}">
Emp ID <input type="text" name="staffId" value='${TeacherData.staffId}'>
Staff Name <input type="text" name="staffName" value='${TeacherData.staffName}'>
</c:when>
</c:choose>
<button type="submit" name="submit">Submit</button>
</form>
</body>
</html>