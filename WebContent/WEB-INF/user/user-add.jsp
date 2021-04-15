<%@page import="cybersoft.java11.utils.PathConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!doctype html>
	<html lang="en">
	  <head>
		<title>User Page</title>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	  </head>
	  <body>
		  <div class="container w-50">
			<h1 class="text-center text-primary p-4">ADD USER PAGE</h1>
			<form action="<c:url value="${PathConst.USER_ADD}"/>" method="post">
			  <div class="form-group">
				<label for="usernameID">Username</label>
				<input type="text"
				  class="form-control" name="username" id="usernameID"  placeholder="Enter your username" required="required">
			  </div>
			  <div class="form-group">
				<label for="passwordID">Password</label>
				<input type="password"
				  class="form-control" name="password" id="passwordID"  placeholder="Enter your password" required="required">
			  </div>
			  <div class="form-group">
				<label for="fullnameID">Full name</label>
				<input type="text"
				  class="form-control" name="fullname" id="fullnameID"  placeholder="Enter your full name" required="required">
			  </div>
			  <div class="form-group">
				<label for="roleID">Role</label>
				<select class="form-control" name="role" id="roleID" required="required">
				  <option value="0">Customer</option>
				  <option value="1">Staff</option>
				  <option value="2">Manager</option>
				</select>
			  </div>
			  <div class="form-group">
				<label for="yearofbirthID">Year of Birth</label>
				<input type="number"
				  class="form-control" name="yearofbirth" id="yearofbirthID" value="2000" required="required">
			  </div>
			  <input class="btn btn-primary" type="submit" value="Register">
			</form>
		  </div>
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	  </body>
	</html>