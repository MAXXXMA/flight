<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $('.confirm-btn').click(function (e) {
            e.preventDefault();
            var a = $(e.currentTarget);
            if (confirm("Are your sure?")) {
                location.assign(a.attr('href'));
            }
        });
    });
</script>
<style>
    dl, dd, dt{margin-bottom: 0.25rem!important;}
</style>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="Index">Flight Booking System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
        <ul class="navbar-nav ">
            <c:if test="${not empty sessionScope.user}">
                <li class="nav-item"><span style="position:relative; top: 8px">Welcome ${sessionScope.user.name}</span></li>
                <li class="nav-item"><a class="nav-link" href="ReservedBooks">My Itinerary</a></li>
                <li class="nav-item"><a class="nav-link" href="Logout">Logout</a></li>
                </c:if>

            <c:if test="${empty sessionScope.user}">
                <li class="nav-item"><a class="nav-link" href="Login">Login</a></li>
                <li class="nav-item"><a class="nav-link" href="SignUp">Sign up</a></li>
                </c:if>
        </ul>
    </div>
</nav>