<%--
  Created by IntelliJ IDEA.
  User: Samit Baral
  Date: 6/16/2023
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${title}</title>
    <%@ include file="/WEB-INF/views/resources.jsp" %>
</head>
<body>
<div class="container">
    <div class="row mt-5">
        <div class="d-flex justify-content-center">${loginMessage}</div>
        <div class="col-6 offset-3 d-flex justify-content-center">
            <form action="signUp" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                    <input type="email" class="form-control" name="email" id="exampleInputEmail1"
                           aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">First Name</label>
                    <input type="text" name="firstName" class="form-control" id="exampleInputFirstName">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Middle Name</label>
                    <input type="text" name="middleName" class="form-control" id="exampleInputMiddleName">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Last Name</label>
                    <input type="text" name="lastName" class="form-control" id="exampleInputLastName">
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <button type="submit" class="btn btn-primary">Sign Up</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
