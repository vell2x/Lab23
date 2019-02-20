<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<h2>Register Here</h2>
 <form action="/registered" method="post">
		<p>
			<label>First Name:</label> 
			<input name="firstName" type="text" pattern="[A-Z][a-z]*" maxlength="20" />
		</p>
		<p>
			<label>Last Name:</label> 
			<input name="lastName" type="text" pattern="[A-Z][a-z]*" maxlength="20" />
		</p>
		<p>
			<label>Email:</label> 
			<input name="email" type="email" maxlength="25" />
		</p>
		<p>
			<label>Phone:</label> 
			<input name="phoneNumber" type="number" step="1" />
		</p>
		<p>
			<label>Password:</label> 
			<input name="password" type="password" />
		</p>
		<p>
			<button>Submit</button>
		</p>
	</form>
</body>
</html>