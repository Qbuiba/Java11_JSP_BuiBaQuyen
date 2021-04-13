<%@page import="cybersoft.java11.utils.PathConst"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login form</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()+PathConst.HOME%>">
		<input type="text" placeholder="enter your message" name="userMessage"/>
		<br>
		<input type="submit" />
	</form>
	
</body>
</html>