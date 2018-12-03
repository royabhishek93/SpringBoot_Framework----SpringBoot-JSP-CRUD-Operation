<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Form</title>
</head>
<body>

 <form:form method="post" action="${path}/address/add" modelAttribute="addressForm">
 	<form:hidden path="id" />
 	<p>Country: <form:input path="country" placeholder="Enter Country"/></p>
 	<p>State: <form:input path="state" placeholder="Enter State"/></p>
 	<p>City: <form:input path="city" placeholder="Enter City"/></p>
 	<p>User:
 		<form:select path="user.id">
 			<c:forEach items="${users}" var="user">
 			<form:option value="${user.id}"> ${user.userName} </form:option>
 			</c:forEach>
 		</form:select>
 	</p>
 	<p>
 		<form:button value="Save">Save</form:button>
 		<a href="${path}/address/list">List</a>
 	</p>
 </form:form>
</body>
</html>