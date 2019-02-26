<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
<link rel="stylesheet" href="/style.css" />
<a href="/">Home</a>
</head>
<body>
<p>Hello ${ profile.username } What would you like to edit?</p>
	<table >
		<form action="admin-edit" method="post">
			<tr>
				<th>Name</th><th>Description</th><th>Quantity</th><th>Prices</th>
			</tr>
			<tr>
				<td><input name="name" type="text" value="${object.name}" pattern="[A-Z][a-z]*" maxlength="20" /></td>
				<td><input name="description" type="text" value="${object.description}" maxlength="50" /></td>
				<td><input name="quantity" type="number" value="${object.quantity}" step="1" /></td>
				<td><input name="price" type="number" value="${object.price}" step="0.01" /></td>
				<td><input name="id" hidden="true" value="${object.id}" /></td>
				<td><button>Finish</button></td>
			</tr>
		</form>
	</table>
</body>
</html>