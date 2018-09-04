<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container">
            <h2 class="text-center my-3">Sign up</h2>
            <div class="row">
                <form class="col-sm-4 offset-sm-4" method="post" onsubmit="return validate()">

                    <c:if test="${not empty param.errorMsg}">
                        <div class="alert alert-danger">${param.errorMsg}</div>
                    </c:if>

                    <div class="form-group">
                        <label>Email</label> <input name="email" class="form-control"
                                                    id="email" required></input>
                    </div>
                    <div class="form-group">
                        <label>Password</label> <input type="password" name="password"
                                                       id="password1" class="form-control"></input>
                    </div>
                    <div class="form-group">
                        <label>Confirm Password</label> <input type="password" name="password2" id="password2"
                                                               class="form-control"></input>
                    </div>
                    <div class="form-group">
                        <label>FUll name</label> <input name="name" class="form-control"
                                                        id="name" required></input>
                    </div>

                    <button class="btn btn-primary btn-block">Sign up</button>
                </form>
            </div>
        </div>

        <script>
            function validate() {
                var username = $('#username').val();
                var password1 = $('#password1').val();
                var password2 = $('#password2').val();
                if (username == "") {
                    alert("User name cannot be empty");
                    return false;
                }
                if (password1 != password2) {
                    alert("Confirm password does not match password");
                    return false;
                }
            }

        </script>
    </body>
</html>