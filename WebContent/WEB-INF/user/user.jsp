<%@page import="cybersoft.java11.utils.PathConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User page</title>
<%@ page import="cybersoft.java11.utils.PathConst" %>
</head>
<body>
	<h1>User page</h1>
	<form method="POST" action="<%=request.getContextPath()+PathConst.HOME%>">
		<p><input type="text" name="userMessage" placeholder="Enter message"/></p>
		<br>
		<input type="submit" value="GO">	
	</form>
</body>
</html>