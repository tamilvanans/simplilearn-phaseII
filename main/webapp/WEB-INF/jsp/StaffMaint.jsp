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
<form action="${fu}SubmitTeacher" method="post">
Teachers
	<select id="StudentStaffList" name="teacher">
		<c:forEach items="${Teachers}" var="teacher">
			<option value=${teacher.staffId}>${teacher.staffName}</option>
		</c:forEach>	
	</select>
Classes
	<select id="ClassList" name="classId">
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