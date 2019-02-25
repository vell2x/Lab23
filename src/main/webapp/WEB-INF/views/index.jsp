<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
	<link rel="stylesheet" href="/style.css" />
</head>
<body>
 <h1> Welcome! Please sign in or register</h1>
 <p><a href="/registration">Register</a></p>
 <div><h1>View our Coffeetory</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th><th>Description</th><th>Quantity</th><th>Prices</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="l" items="${list}">
				<tr>
					<td>${l.name}</td>
					<td>${l.description}</td>
					<td>${l.quantity}</td>
					<td>${l.price}</td>
					<td><form action="/add-to-cart" method="get">
					<input name="id" hidden=true value="${l.id}" />
					<button>Add to Cart</button>
					</form></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
<p><a href="/admin">Admin</a></p>
</body>
</html>