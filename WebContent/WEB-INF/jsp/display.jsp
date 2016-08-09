<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ page session="false" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<c:out value="${username}" />
	</h3>
	<br />
	<c:forEach var="map" items="${map}">
		<td>${map.key}</td>.<td>${map.value}<br /></td>
	</c:forEach>
	<c:forEach var="stockprice" items="${stockprice}">
	<%-- <c:if test="${map.value == stockprice.key}"> --%>
	<c:if test="${sessionScope.map.value == sessionScope.stockprice.key}">
		<c:out value="${stockprice.value} "></c:out></c:if>
		<br />
	</c:forEach>
</body>
</html>