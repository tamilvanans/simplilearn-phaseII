<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Master</title>
</head>
<body>
<form> 
<h1>Student Master</h1>		
<br/>
	<table border="1">
				<tr>
					<td> Select </td>
					<td> Roll No </td>
					<td> Name </td>
				</tr>
		<c:forEach items="${StudentMaster}" var="student">
				<tr>
					<td> <input type="radio" name="rollNo" value="${student.studentId}" /> </td>
					<td>${student.studentId}</td>
					<td>${student.studentName}</td>
				</tr>
		</c:forEach>
	</table>
<br/>
<br/>
<button name="action" value="AddMod">Add/Modify </button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button name="action" value="Delete">Delete</button>
</form>
</body>
</html>