<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form> 
<h1>Students Details</h1>
<br/>
	<table border="1">
				<tr>
					<td> Select </td>
					<td> Name </td>
					<td> Class </td>
					<td> Subject </td>
				</tr>
		<c:forEach items="${StudentDetails}" var="student">
				<tr>
					<td> <input type="radio" name="student" value="${student.id}" /> </td>
					<td>${student.rollNo}</td>
					<td>${student.classId}</td>
					<td>${student.subjectId}</td>
				</tr>
		</c:forEach>
	</table>
<br/>
<br/>
<button name="action" value="AddMod">Add </button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button name="action" value="Delete">Delete</button>
</form>
</body>
</html>