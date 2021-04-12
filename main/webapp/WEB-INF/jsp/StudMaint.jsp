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
<form action="/SchoolApp/SubmitStudent" method="post"> 
Students
	<select id="StudentStaffList" name="student">
		<c:forEach items="${Students}" var="student">
			<option value=${student.studentId}>${student.studentName}</option>
		</c:forEach>	
	</select>
Classes
	<select id="ClassList" name="class">
		<c:forEach items="${Classes}" var="class">
			<option value=${class.classId}>${class.classDesc}</option>
		</c:forEach>	
	</select>
Subjects
	<select id="SubjectList" name="subject">
		<c:forEach items="${Subjects}" var="subject">
			<option value=${subject.subjectId}>${subject.subjectName}</option>
		</c:forEach>	
	</select>
<button type="submit" name="submit">Submit</button>
</form>
</body>
</html>