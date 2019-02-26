<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
<link rel="stylesheet" href="/style.css" />
</head>
<body>
<h3>Add ${object.name} to cart</h3>
<p>Welcome ${ profile.firstName } ${ profile.lastName } </p>
	<table >
			<tr>
				<th>Name</th><th>Description</th><th>Quantity</th><th>Prices</th>
			</tr>
			<tr>
				<td>${object.name}</td>
				<td>${object.description}</td>
				<td>${object.quantity}</td>
				<td>${object.price}</td>
				<td><form action="/item-added" method="post">
				<input name="id" hidden="true" value="${object.id}"/>
				<input name="name" hidden="true" value="${object.name}"/>
				<input name="quantity" hidden="true" value="${object.quantity}"/>
				<input name="price" hidden="true" value="${object.price}"/>
				<button>Add Item</button></form></td>
			</tr>
	</table>
</body>
</html>