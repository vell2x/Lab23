<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Successful</title>
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<h1>Congratulations you are registered</h1>
	<p>Hello ${ firstname } ${ lastname } </p>
	<p><a href="/">Home</a></p>
</body>
</html>