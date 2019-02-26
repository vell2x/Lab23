<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="/style.css" />
<a href="/">Home</a> &nbsp; <a href="/registration">Register User</a>
</head>
<body>
	<div><h1>View our Coffeetory</h1>
	<p>Hello ${ profile.username }</p>
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
					
					<td><form action="admin-edit" method="get">
					<input name="id" hidden=true value="${l.id}" />
					<button>Edit</button>
					</form></td>
					
					<td><form action="admin-delete" method="post">
					<input name="id" hidden=true value="${l.id}" />
					<button>Delete</button>
					</form></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<table>
		<form action="admin-add" method="post">
		<tr>
			<th>Name</th><th>Description</th><th>Quantity</th><th>Prices</th>
		</tr>
		<tr>
			<td><input name="name" type="text" pattern="[A-Z][a-z]*" maxlength="20" /></td>
			<td><input name="description" type="text" maxlength="50" /></td>
			<td><input name="quantity" type="number" step="1" /></td>
			<td><input name="price" type="number" step="0.01" /></td>
		</tr>
		<tr><td><button>Add new Item</button></td></tr>
	</form>
	</table>
</body>
</html>