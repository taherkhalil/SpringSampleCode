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
	<%-- <form:checkbox path="productStock" value="${stockmap}"/> --%>
	
	
	<% out.print(request.getSession().getAttribute("username")); %>
	jstl wala:<c:out value="${sessionScope.username }"/>
	<h2>${msg}</h2>
<!-- 	<a href="test.htm">Click here to test Exception handling</a> -->

	<form:form commandName="productBean" method="POST"  action="display">

		
		
			  <form:select path="productStock" name ="items" required= "required" multiple="multiple">
			  <c:forEach var="stockmap" items="${stockmap}">
			  <option  value="${stockmap}"> <c:out value="${stockmap.key} "></c:out></option>
			  
			<br />
			</c:forEach>
			</form:select>
		
		<form:button name="add" value="submit">submit</form:button>
	</form:form>
</body>
</html>