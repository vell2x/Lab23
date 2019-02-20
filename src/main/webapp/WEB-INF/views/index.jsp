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
					<th>Name</th><th>Description</th><th>Quantity</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${item}">
				<tr>
					<td>${ list.name }</td>
					<td>${ list.description }</td>
					<td>${ list.quantity }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table></div>
</body>
</html>