<%@page import="cybersoft.java11.utils.PathConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>User Dashboard</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    </head>
    
    <body>
      <div class="container">
	      <h1 class="p-4 text-center text-uppercase text-warning">Add New User</h1>
	      <div class="mb-2 ml-2">
	          <form method="post" action="<%=request.getContextPath() + PathConst.USER_ADD %>">
	          	<p>
		            <label for="fullname">Full name </label>
		            <input type="text" placeholder="full name" name="fullname" required>
		          </p>
		          <p>
		            <label for="dayofbirth">Day of Birth </label>
		            <input type="text" placeholder="day of birth"  name="dayofbirth" required>
		          </p>
		          <p>
		            <label for="username">Username </label>
		            <input type="text" placeholder="username"  name="username" required>
		          </p>
		          <p>
		            <label for="password">Password </label>
		            <input type="password" placeholder="password"  name="password" required>
		          </p>
		          <p>
		            <label for="role">Role </label>
		            <input type="text" placeholder="role"  name="role" required>
		          </p>
		          <input type="submit" value="ADD">
	          </form>
	      </div>  
      </div>
    
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    </body>
    
</html>