<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value = "en_AU"/>
<!DOCTYPE html">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flight System Admin</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <div class="container-fluid">

            <h2 class="my-3">Manage all flights</h2>


            <div class="text-right mb-3">
                <a class="btn btn-info" href="AdminEditFlight">Add new flight</a>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-bordered data-table">
                        <thead>
                            <tr>
                                <th>Flight Number</th>
                                <th>From City</th>
                                <th>To City</th>
                                <th>Departure</th>
                                <th>Arrive</th>
                                <th>Economic Seat Price</th>
                                <th>First Class Seat Price</th>
                                <th>Economic Seats left</th>
                                <th>First class seats left</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="flight" items="${flights}">
                                <tr>
                                    <td>${flight.flightNumber}</td>
                                    <td>${flight.fromCity}</td>
                                    <td>${flight.toCity}</td>
                                    <td><fmt:formatDate type = "both" 
                                                    dateStyle = "short" timeStyle = "short" value = "${flight.departureDate}" />
                                    </td>
                                    <td><fmt:formatDate type = "both" 
                                                    dateStyle = "short" timeStyle = "short" value = "${flight.arriveDate}" /></td>
                                    <td>$ ${flight.seatPrice}</td>
                                    <td>$ ${flight.firstClassSeatPrice}</td>
                                    <td>${flight.seats}</td>
                                    <td>${flight.firstClassSeats}</td>
                                    <td>
                                        <a href="AdminRemoveFlight?flightId=${flight.flightId}" class="btn btn-danger confirm-btn">Delete</a>
                                        <a href="AdminFlightDetail?flightId=${flight.flightId}" class="btn btn-primary">Detail</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <br>
        <br>
    </body>
</html>