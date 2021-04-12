<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Master</title>
</head>
<body>
<form> 
<h1>Class Master</h1>
			
<br/>
	<table border="1">
				<tr>
					<td> Select </td>
					<td> Class </td>
					<td> Description </td>
				</tr>
		<c:forEach items="${ClassMaster}" var="class">
				<tr>
					<td> <input type="radio" name="classId" value="${class.classId}" /> </td>
					<td>${class.classId}</td>
					<td>${class.classDesc}</td>
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