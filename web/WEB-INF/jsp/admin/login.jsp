<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <div class="container">
            <br>
            <h2 class="text-center my-3">Login</h2>
            <div class="row">
                <form class="col-sm-4 offset-sm-4" method="post">

                    <c:if test="${not empty param.errorMsg}">
                        <div class="alert alert-danger">${param.errorMsg}</div>
                    </c:if>

                    <input type="hidden" name="returnUrl" value="${param.returnUrl}">

                    <div class="form-group">
                        <label>Username</label> <input type="username" name="email" class="form-control" required></input>
                    </div>
                    <div class="form-group">
                        <label>Password</label> <input type="password" name="password"
                                                       class="form-control" required></input>
                    </div>
                    <br>

                    <div>
                        <button class="btn btn-primary btn-block">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>