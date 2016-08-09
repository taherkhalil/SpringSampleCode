<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1><c:out value="${username}"/></h1>
	
	
	<% out.print(request.getSession().getAttribute("yahoo")); %>
	<h2>${msg}</h2>
<!-- 	<a href="test.htm">Click here to test Exception handling</a> -->
	<form:form commandName="ProductBean" method="POST" action="add">

		<c:forEach var="stockmap" items="${stockmap}">
		<td><form:checkbox path="productStock" value="${stockmap}"/>
			  
			   <c:out value="${stockmap.key} "></c:out></td>
			<br />
		</c:forEach>
		<form:button>submit</form:button>
	</form:form>
</body>
</html>