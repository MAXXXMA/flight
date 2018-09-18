<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

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
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="Admin">Flight Booking System Admin</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
        <ul class="navbar-nav ">
            <c:if test="${not empty sessionScope.admin}">
                <li class="nav-item"><span style="position:relative; top: 8px">Welcome Admin</span></li>
                <li class="nav-item"><a class="nav-link" href="AdminBookings">All bookings</a></li>
                <li class="nav-item"><a class="nav-link" href="AdminFlights">All flights</a></li>
                <li class="nav-item"><a class="nav-link" href="AdminLogout">Logout</a></li>
                </c:if>

            <c:if test="${empty sessionScope.admin}">
                <li class="nav-item"><a class="nav-link" href="AdminSignUp">Sign up</a></li>
                </c:if>
        </ul>
    </div>
</nav>