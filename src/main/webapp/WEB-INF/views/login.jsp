<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coffee Login</title>
</head>
<body>
	<h1>Login</h1>
	
	<p class="message">${ message }</p>
	
	<form action="/login" method="post">
		<p>
			<label>Username:</label> 
			<input id="username" name="username" type="text" required />
		</p>
		<p>
			<label>Password:</label> 
			<input id="password" type="password" name="password" required />
		</p>
		<p>
			<button>Submit</button>
		</p>
	</form>
	
	or
	
	<p>
		Don't have an account yet? <a href="/registration">Sign up here</a>.
	</p>
</body>
</html>