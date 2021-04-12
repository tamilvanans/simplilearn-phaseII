<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Staff Menu Page</title>
</head>
<body>
<a href="${fu}maintStudList">Master List-Students-Add/Modify/Delete/View</a>
<br/>
<br/>
<a href="${fu}maintStaffList">Master List-Teachers-Add/Modify/Delete/View</a>
<br/>
<br/>
<a href="${fu}maintClassList">Master List-Classes-Add/Modify/Delete/View</a>
<br/>
<br/>
<a href="${fu}maintSubjectList">Master List-Subjects-Add/Modify/Delete/View</a>
<br/>
<br/>
<h3><a href="${fu}viewStudMaint">Student Class Mapping Maintenance-Add/Delete/View</a></h3>
<br/>
<br/>
<h3><a href="${fu}viewStaffMaint">Teacher Class Mapping Maintenance-Add/Delete/View</a></h3>
<br/>
<br/>
</body>
</html>