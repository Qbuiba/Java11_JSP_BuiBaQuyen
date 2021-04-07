<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test page</title>
</head>
<body>
	<%--COMMENT IS HERE --%>
	<%!void showMessage(){
		System.out.println("message from test page");
		}
	%>
	<% for(int i=0;i<5;i++){%>
		<h2>hello JSP</h2>
		<% showMessage(); %>
	<%}%>
	<h1>TEST PAGE</h1>
</body>
</html>