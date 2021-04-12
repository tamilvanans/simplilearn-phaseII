<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
<form action="/ValidLogin" method="post">
User Name: <input type="text" name="username" />
Password: <input type="password" name="password" />
<button type="submit" name="submit">Submit</button>
</form>
</body>
</html>