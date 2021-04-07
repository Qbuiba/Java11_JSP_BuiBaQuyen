<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<h1>Home Page 111111111111111</h1>
	<h2>222222222222222</h2>
	
	<%if(request.getAttribute("message")!=null){ %>
		<h2><%= request.getAttribute("message") %></h2>
	<%} %>
	
	<%if(request.getAttribute("userMessage")!=null){ %>
		<h2><%= request.getAttribute("userMessage") %></h2>
	<%} %>
</body>
</html>