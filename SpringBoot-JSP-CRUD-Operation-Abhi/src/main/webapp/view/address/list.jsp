<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address List</title>
</head>
<body>
<body>

	<table border="1">
	<thead>
			<tr>
			<th>Country</th>
			<th>State</th>
			<th>City</th>
			<th>User</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${addresses}" var="address">
		<tr>
			<td>${address.country}</td>
			<td>${address.state}</td>
			<td>${address.city}</td>
			<td>${address.user.userName}</td>
			<td><a href="${path}/address/edit/${address.id}">Edit</a></td>
			<td><a href="${path}/address/delete/${address.id}">Delete</a></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
		<p><a href="${path}">Welcome</p>
</body>
</body>
</html>