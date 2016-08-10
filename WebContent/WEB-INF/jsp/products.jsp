<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Product</title>
</head>
<body>
	<h1>
		welcome:
		<%
		out.print(request.getSession().getAttribute("username"));
	%>
	</h1>

	<!-- 	<a href="test.htm">Click here to test Exception handling</a> -->
<%-- 	<c:forEach var="pricemap" items="${pricemap}">
			${pricemap.value}
						price:<c:out value="${pricemap.value} "></c:out>
	</c:forEach> --%>
	<br />
	<form:form commandName="productBean" method="POST" action="display">
		<form:select path="productStock" name="items" required="required"
			multiple="multiple">
			<c:forEach var="pricemap" items="${pricemap}">
				<option value="${pricemap}">
					<c:out value="${pricemap.key} "></c:out></option>
			</c:forEach>
		</form:select>
		<form:button name="add" value="submit">submit</form:button>
	</form:form>
	<form method="GET" action="logout">
		<input type="submit" value="logout">
	</form>
</body>
</html>