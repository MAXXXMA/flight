<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html">
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin mange Bookings</title>
    </head>

    <body>
        <jsp:include page="header.jsp" />

        <div class="container-fluid">

            <h2 class="my-3">Manage All Bookings</h2>
            <div class="text-right my-3">
                <a class="btn btn-info" href="AdminAddBooking">Create booking</a>
            </div>

            <table class="table table-bordered data-table">
                <thead>
                    <tr>
                        <th>Booking Id</th>
                        <th>Created</th>
                        <th>Flight Number</th>
                        <th>From City</th>
                        <th>To City</th>
                        <th>Departure</th>
                        <th>Arrive</th>
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
                            <td>${booking.bookingId}</td>
                            <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${booking.created}" />
                            </td>
                            <td><a href="AdminFlightDetail?flightId=${booking.flight.flightId}">${booking.flight.flightNumber}</a></td>
                            <td>${booking.flight.fromCity}</td>
                            <td>${booking.flight.toCity}</td>
                            <td>
                                <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${booking.flight.departureDate}" />
                            </td>
                            <td>
                                <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${booking.flight.arriveDate}" />
                            </td>

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

        <br>
        <br>
    </body>

</html>