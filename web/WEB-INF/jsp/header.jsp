<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.26.29/sweetalert2.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<link rel="stylesheet" href="./css/main.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.26.29/sweetalert2.all.min.js"></script>


<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>


<script>
    $(document).ready(function () {
        $('.confirm-btn').click(function (e) {
            e.preventDefault();
            var a = $(e.currentTarget);
            if (confirm("Are your sure?")) {
                location.assign(a.attr('href'));
            }
        });

        $('.data-table').DataTable();
    });
</script>
<style>
    dl, dd, dt{margin-bottom: 0.25rem!important;}
</style>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="Index">Flight Booking System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
        <ul class="navbar-nav ">
            <c:if test="${not empty sessionScope.user}">
                <li class="nav-item"><span style="position:relative; top: 8px">Welcome ${sessionScope.user.name}</span></li>
                <li class="nav-item"><a class="nav-link" href="MyBookings">My Booked Flights</a></li>
                <li class="nav-item"><a class="nav-link" href="Logout">Logout</a></li>
                </c:if>

            <c:if test="${empty sessionScope.user}">
                <li class="nav-item"><a class="nav-link" href="Login">Login</a></li>
                <li class="nav-item"><a class="nav-link" href="SignUp">Sign up</a></li>
            </c:if>
        </ul>
    </div>
</nav>