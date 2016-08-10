<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ page session="false" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart details</title>
</head>
<body>
	<h3>
		<c:out value="${username}" />
	</h3>
	<br />
	<td>index</td>
	<td>item</td>
	<td>price</td>
	<br />
	<c:forEach var="map" items="${map}">
		<td>${map.key}</td>.             <td>${map.value}<br /></td>
	</c:forEach>
	<form method="GET" action="/SpringCart/products">
		<input type="submit" value="add more to cart"
			onclick="/SpringCart/products">
	</form>

	<form action="display" method="post">
		enter index of item to delete<input type="number" name=key> <input
			type="submit" name="del" value="delete">
	</form>
		<form method="GET" action="checkout">
		<input type="submit" value="checkout">
	</form>
	<form method="GET" action="logout">
		<input type="submit" value="logout">
	</form>
</body>
</html>