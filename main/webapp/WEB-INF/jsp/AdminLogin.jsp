<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator Login</title>
<h1>Welcome Admin to Learner's Academy</h1>
</head>
<body>
<form action="/SchoolApp/ValidLogin" method="post">
User Name: <input type="text" name="username" />
<br />
<br />
Password: <input type="password" name="password" />
<br />
<br />
<button type="submit" name="submit">Submit</button>
</form>
</body>
</html>