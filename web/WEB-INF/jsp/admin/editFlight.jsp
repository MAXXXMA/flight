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

            <h2 class="my-3">
                <c:if test="${empty flight.flightNumber}">
                    Create flight
                </c:if>
                <c:if test="${not empty flight.flightNumber}">
                    Edit flight
                </c:if>
            </h2>

            <form class="card-body" method="post">
                <div class="row">
                    <div class="col-6">

                        <div class="form-group">
                            <label>Flight Number</label> 
                            <input type="input" class="form-control" name="flightNumber" value="${flight.flightNumber}" required>
                        </div>

                        <div class="form-group">
                            <label>From City</label> 
                            <select class="custom-select" name="fromCity" required>
                                <option value="">Select</option>
                                <option value="Sydney" ${flight.fromCity == 'Sydney' ? 'selected' : ''}>Sydney</option>
                                <option value="Melbourne" ${flight.fromCity == 'Melbourne' ? 'selected' : ''}>Melbourne</option>
                                <option value="Cairns" ${flight.fromCity == 'Cairns' ? 'selected' : ''}>Cairns</option>
                                <option value="Gold Coast" ${flight.fromCity == 'Gold Coast' ? 'selected' : ''}>Gold Coast</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>To City</label> 
                            <select class="custom-select" name="toCity" required>
                                <option value="">Select</option>
                                <option value="Sydney" ${flight.toCity == 'Sydney' ? 'selected' : ''}>Sydney</option>
                                <option value="Melbourne" ${flight.toCity == 'Melbourne' ? 'selected' : ''}>Melbourne</option>
                                <option value="Cairns" ${flight.toCity == 'Cairns' ? 'selected' : ''}>Cairns</option>
                                <option value="Gold Coast" ${flight.toCity == 'Gold Coast' ? 'selected' : ''}>Gold Coast</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Departure (yyyy-MM-dd HH:mm:ss)</label> 
                            <input type="input" class="form-control" name="departure" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"value = "${flight.departureDate}" />" required>
                        </div>
                        <div class="form-group">
                            <label>Arrive (yyyy-MM-dd HH:mm:ss)</label> 
                            <input type="input" class="form-control" name="arrive" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value = "${flight.departureDate}" />" required>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label>Economic Seat Price</label> 
                            <input type="number" min="1" class="form-control" name="seatPrice" value="${flight.seatPrice}" required>
                        </div>
                        <div class="form-group">
                            <label>First class Seat Price</label> 
                            <input type="number" min="1" class="form-control" name="firstClassSeatPrice" value="${flight.firstClassSeatPrice}" required>
                        </div>

                        <div class="form-group">
                            <label>Economic Seat left</label> 
                            <input type="number" min="1" class="form-control" name="seats" value="${flight.seats}" required>
                        </div>

                        <div class="form-group">
                            <label>First class Seat left</label> 
                            <input type="number" min="1" class="form-control" name="firstClassSeats" value="${flight.firstClassSeats}" required>
                        </div>


                        <button class="btn btn-primary btn-block" type="submit">Submit</button>
                    </div>
                </div>

            </form>
            <br>
            <br>
        </div>
    </body>
</html>