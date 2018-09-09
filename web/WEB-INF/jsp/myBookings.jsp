<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My Bookings</title>
</head>

<body>
    <jsp:include page="header.jsp" />

    <div class="container">

        <h2 class="my-3">My Bookings</h2>

        <div class="accordion" id="accordionExample">
            <c:forEach var="booking" items="${bookings}">
                <div class="card">
                    <div class="card-header" id="headingO">
                        <h5 class="mb-0">
                            <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse${booking.bookingId}">
                                #${booking.bookingId} </button>
                            <span class="float-right text-muted">Created:
                                <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${booking.created}" /></span>

                        </h5>
                    </div>

                    <div id="collapse${booking.bookingId}" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                        <div class="card-body">
                            <table class="table table-bordered">
                                <tr>
                                    <th>Flight Number</th>
                                    <th>From City</th>
                                    <th>To City</th>
                                    <th>Departure</th>
                                    <th>Arrive</th>
                                    <th>Type</th>
                                    <th>Quantity</th>
                                    <th>Total Price</th>
                                    <th>Action</th>
                                </tr>
                                <tr>
                                    <th><a href="FlightDetail?flightId=${booking.flight.flightId}">${booking.flight.flightNumber}</a></th>
                                    <th>${booking.flight.fromCity}</th>
                                    <th>${booking.flight.toCity}</th>
                                    <td>
                                        <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${booking.flight.departureDate}" />
                                    </td>
                                    <td>
                                        <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${booking.flight.arriveDate}" />
                                    </td>
                                    <th>${booking.type}</th>
                                    <th>${booking.quantity}</th>
                                    <th>$ ${booking.price}</th>
                                    <th><a class="btn btn-sm btn-danger confirm-btn" href="CancelBooking?bookingId=${booking.bookingId}">Cancel</a></th>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <br>
    <br>
</body>

</html>