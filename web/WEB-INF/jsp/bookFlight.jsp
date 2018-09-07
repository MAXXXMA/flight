<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Flight</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <div class="container">

            <h3 class="my-3 text-center">Congratulations, you have sucessfully booked ${booking.quantity} ${booking.type} tickets. your booking id is #${booking.bookingId}</h3>

            <p class="text-center">Go to <a href="MyBookings">My Bookings</a> page to view all your bookings.</p>

        </div>
    </body>
</html>