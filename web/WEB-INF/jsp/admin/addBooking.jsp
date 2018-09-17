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
        <title>Admin Create Booking</title>
    </head>

    <body>
        <jsp:include page="header.jsp" />

        <div class="container-fluid">

            <h2 class="my-3">Create new booking</h2>

            <c:if test="${not empty param.errorMsg}">
                <div class="alert alert-danger">${param.errorMsg}</div>
            </c:if>

            <form method="post">
                <div class="row">
                    <div class="col-3">
                        <div class="form-group">
                            <label>Pick a flight</label>
                            <select class="form-control" name="flightId">
                                <c:forEach var="flight" items="${flights}">
                                    <option value="${flight.flightId}">${flight.flightNumber} ${flight.fromCity} - ${flight.toCity} (
                                        <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${flight.departureDate}" />
                                        )</option>
                                    </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="form-group">
                            <label>Pick a user</label>
                            <select class="form-control" name="userId">
                                <c:forEach var="user" items="${users}">
                                    <option value="${user.userId}">${user.name} (${user.email})</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="form-group">
                            <label>Seat Type</label>
                            <select class="form-control" name="type">
                                <option value="Economic">Economic</option>
                                <option value="First class">First class</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-3">

                        <div class="form-group">
                            <label>Ticket Quantity</label>
                            <input name="quantity" type="number" min="1" max="200" class="form-control" value="1" required>
                        </div>
                    </div>

                </div>
                
                <div class="text-right">
                    <button class="btn btn-primary" type="submit">Create</button>
                </div>
            </form>
        </div>

        <br>
        <br>
    </body>

</html>