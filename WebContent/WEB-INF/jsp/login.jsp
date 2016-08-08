<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<form:form method="POST" commandName="loginBean" action="login">
   Enter User Name:<form:input type="email" path="email" name="email" />
		<td><form:errors path="email" cssstyle="color: red;"></form:errors></td>  
   Enter Password :<form:input type="password" path="password"
			name="password" />
		<td><form:errors path="password" cssstyle="color: red;"></form:errors></td>
		<br />
		<input type="submit" value="login">
		<div style="color: red">${error1}</div>
		</div>
	</form:form>
</body>
</html>