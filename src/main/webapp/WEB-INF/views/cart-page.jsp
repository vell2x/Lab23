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
	<table >
			<tr>
				<th>Name</th><th>Quantity</th><th>Prices</th>
			</tr>
			<form action="/item-added" method="post">
			<tr>
				<td>${cartItem.name}</td>
				<td>${cartItem.quantity}</td>
				<td>${cartItem.price}</td>
				<td><button>Add Item</button></td>
			</tr>
		</form>
	</table>
</body>
</html>