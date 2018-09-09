<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flight System Admin</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <div class="container-fluid">

            <h2 class="my-3"><em>${flight.flightNumber}</em></h2>

            <div class="row">
                <div class="col-4">
                    <div class="card mb-3">
                        <div class="card-header bg-primary text-white">
                            ${flight.flightNumber}
                        </div>
                        <div class="card-body">
                            <dl class="row">
                                <dt class="col-4">From city</dt>
                                <dd class="col-8">${flight.fromCity}</dd>
                            </dl>
                            <dl class="row">
                                <dt class="col-4">To city</dt>
                                <dd class="col-8">${flight.toCity}</dd>
                            </dl>
                            <dl class="row">
                                <dt class="col-4">Departure</dt>
                                <dd class="col-8"><fmt:formatDate type = "both" 
                                                dateStyle = "short" timeStyle = "short" value = "${flight.departureDate}" /></dd>
                            </dl>
                            <dl class="row">
                                <dt class="col-4">Arrive</dt>
                                <dd class="col-8"><fmt:formatDate type = "both" 
                                                dateStyle = "short" timeStyle = "short" value = "${flight.arriveDate}" /></dd>
                            </dl>
                            <dl class="row">
                                <dt class="col-4">Economic Seat Price</dt>
                                <dd class="col-8">$ ${flight.seatPrice}</dd>
                            </dl>
                            <dl class="row">
                                <dt class="col-4">First class Seat Price</dt>
                                <dd class="col-8">$ ${flight.firstClassSeatPrice}</dd>
                            </dl>
                            <dl class="row">
                                <dt class="col-4">Economic Seats left</dt>
                                <dd class="col-8">${flight.seats}</dd>
                            </dl>
                            <dl class="row">
                                <dt class="col-4">First class Seat left</dt>
                                <dd class="col-8">${flight.firstClassSeats}</dd>
                            </dl>
                            <a class="btn btn-info btn-block" href="AdminEditFlight?flightId=${flight.flightId}">Edit Flight</a>
                        </div>
                    </div>
                </div>

                <div class="col-8">

                    <div class="card mb-3">
                        <div class="card-header bg-primary text-white">
                            All bookings for this flight
                        </div>
                        <div class="card-body">

                            <table class="table table-bordered data-table">
                                <thead>
                                    <tr>
                                        <th>User</th>
                                        <th>Type</th>
                                        <th>Quantity</th>
                                        <th>Total Price</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="booking" items="${bookings}">
                                        <tr>
                                            <td>${booking.user.name} (${booking.user.email})</td>
                                            <td>${booking.type}</td>
                                            <td>${booking.quantity}</td>
                                            <td>$ ${booking.price}</td>
                                            <td><a class="btn btn-primary btn-sm confirm-btn" href="AdminCancelBooking?bookingId=${booking.bookingId}&returnUrl=flightDetail">Cancel</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>

            </div>

            <br>
            <br>
            </body>
            </html>