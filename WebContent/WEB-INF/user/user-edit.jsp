<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="cybersoft.java11.utils.PathConst"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!doctype html>
    <html lang="en">
      <head>
        <title>Edit User Page</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      </head>
      <body>
          <div class="container-fluid d-flex flex-column justify-content-center align-items-center">
            <h1 class="text-center text-primary p-4">EDIT USER PAGE</h1>
            <form action="<c:url value="${PathConst.USER_EDIT}"/>" method="post" class="p-4 w-50">
              <div class="form-group">
                <label for="usernameID">Username</label>
                <input type="text"
                  class="form-control" name="username" id="usernameID"  value="${user.username}" readonly>
              </div>
              <div class="form-group">
                <label for="passwordID">Password</label>
                <input type="text"
                  class="form-control" name="password" id="passwordID"  value="${user.password}">
              </div>
              <div class="form-group">
                <label for="fullnameID">Full name</label>
                <input type="text"
                  class="form-control" name="fullname" id="fullnameID"  value="${user.hoVaTen}">
              </div>
              <div class="form-group">
                <label for="roleID">Role</label>
                <select class="form-control" name="role" id="roleID">
                  <option value="0" <c:if test="${user.chucVu==0}"> selected</c:if>>Customer</option>
                  <option value="1"  <c:if test="${user.chucVu==1}"> selected</c:if>>Staff</option>
                  <option value="2"  <c:if test="${user.chucVu==2}"> selected</c:if>>Manager</option>
                </select>
              </div>
              <div class="form-group">
                <label for="yearofbirthID">Year of Birth</label>
                <input type="number"
                  class="form-control" name="yearofbirth" id="yearofbirthID" value="${user.namSinh}">
              </div>
              <input class="btn btn-primary btn-lg" type="submit" value="Update">
              <a class="btn btn-outline-info btn-lg ml-4" href="<c:url value="${PathConst.USER_DASHBOARD}"/>"> Cancel</a>
            </form>
          </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      </body>
    </html>