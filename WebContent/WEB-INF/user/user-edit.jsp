<%@page import="cybersoft.java11.utils.PathConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cybersoft.java11.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <title>Update user</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
	<% User user= (User)request.getAttribute("reqUser"); %>
    <div class="container-fluid">
      <h1 class="text-primary text-center p-4">Update User page</h1>
      <div class="text-danger">
      </div>
      <form action="<%=request.getContextPath()+PathConst.USER_EDIT %>" method="POST" class="shadow p-4 w-50 ">
        <div class="form-group">
          <label for="usernameId">Username</label>
          <input type="text"
            class="form-control" name="username" id="usernameId" value="${user.username}" readonly>
        </div>
        <div class="form-group">
          <label for="passwordId">Password</label>
          <input type="text" class="form-control" name="password" id="passwordId" value="${user.password}">
        </div>
        <div class="form-group">
          <label for="fulnameId">Full name</label>
          <input type="text" class="form-control" name="fulname" id="fulnameId" value="${user.hoVaTen}">
        </div>
        <div class="form-group">
          <label for="roleId">Role</label>
          <select class="form-control" name="role" id="roleId">
            <option value="0"<c:if test="${user.chucVu==0}">selected</c:if>>Customer</option>
            <option value="1"<c:if test="${user.chucVu==1}">selected</c:if>>Staff</option>
            <option value="2"<c:if test="${user.chucVu==2}">selected</c:if>>Manager</option>
          </select>
        </div>
        <div class="form-group">
          <label for="birthdayId">Birthday</label>
          <input type="number"
            class="form-control" name="birthday" id="birthdayId" value="${user.namSinh}">
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
      </form>
    </div>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>