<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%-- <body>
<form:form method="post" modelAttribute="userForm" action="firstpage"> --%>
<body>
  <form:form action="usercheck" method="post">
   Enter User Name:<input type="text" name="name"> <br/>
   Enter Password :<input type="password" name="pwd"/><br/>
   <input type="submit">
  </form:form>
</body>
</html>