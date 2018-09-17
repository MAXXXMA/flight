<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_AU" />
<!DOCTYPE html">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Flight System</title>
</head>

<body>
    <jsp:include page="header.jsp" />

    <div class="container">

        <h2 class="my-3">Welcome to flight system</h2>


        <c:if test="${not searched}">
            <div class="row">
                <div class="col-md-8 offset-md-2 col-lg-6 offset-lg-3">
                    <div class="card">
                        <div class="card-header">
                            Search Flight
                        </div>
                        <form class="card-body" action="Index">
                            <div class="form-group">
                                <label>From City</label>
                                <select class="custom-select" name="fromCity">
                                    <option value="">Select</option>
                                    <option value="Sydney">Sydney</option>
                                    <option value="Melbourne">Melbourne</option>
                                    <option value="Cairns">Cairns</option>
                                    <option value="Gold Coast">Gold Coast</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>To City</label>
                                <select class="custom-select" name="toCity">
                                    <option value="">Select</option>
                                    <option value="Sydney">Sydney</option>
                                    <option value="Melbourne">Melbourne</option>
                                    <option value="Cairns">Cairns</option>
                                    <option value="Gold Coast">Gold Coast</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Departure</label>
                                <input type="date" class="form-control" name="departure">
                            </div>
                            <button class="btn btn-primary btn-block" type="submit">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${searched}">
            <div class="row">
                <div class="col-md-3">
                    <div class="card">
                        <div class="card-header">
                            Search Flight
                        </div>
                        <form class="card-body" action="Index">
                            <div class="form-group">
                                <label>From City</label>
                                <select class="custom-select" name="fromCity">
                                    <option value="">Select</option>
                                    <option value="Sydney" ${param.fromCity == 'Sydney' ? 'selected' : ''}>Sydney</option>
                                    <option value="Melbourne" ${param.fromCity == 'Melbourne' ? 'selected' : ''}>Melbourne</option>
                                    <option value="Cairns" ${param.fromCity == 'Cairns' ? 'selected' : ''}>Cairns</option>
                                    <option value="Gold Coast" ${param.fromCity == 'Gold Coast' ? 'selected' : ''}>Gold Coast</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>To City</label>
                                <select class="custom-select" name="toCity">
                                    <option value="">Select</option>
                                    <option value="Sydney" ${param.toCity == 'Sydney' ? 'selected' : ''}>Sydney</option>
                                    <option value="Melbourne" ${param.toCity == 'Melbourne' ? 'selected' : ''}>Melbourne</option>
                                    <option value="Cairns" ${param.toCity == 'Cairns' ? 'selected' : ''}>Cairns</option>
                                    <option value="Gold Coast" ${param.toCity == 'Gold Coast' ? 'selected' : ''}>Gold Coast</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Departure</label>
                                <input type="date" class="form-control" name="departure" value="${param.departure}">
                            </div>
                            <button class="btn btn-primary btn-block" type="submit">Submit</button>
                        </form>
                    </div>
                </div>
                <div class="col-md-9">
                    <table class="table table-bordered data-table">
                        <thead>
                            <tr>
                                <th>Flight Number</th>
                                <th>From City</th>
                                <th>To City</th>
                                <th>Departure</th>
                                <th>Arrive</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="flight" items="${flights}">
                                <tr>
                                    <td>${flight.flightNumber}</td>
                                    <td>${flight.fromCity}</td>
                                    <td>${flight.toCity}</td>
                                    <td>
                                        <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${flight.departureDate}" />
                                    </td>
                                    <td>
                                        <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${flight.arriveDate}" />
                                    </td>
                                    <td><a href="FlightDetail?flightId=${flight.flightId}" class="btn btn-primary">Detail</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:if>

    </div>

    <br>
    <br>
</body>

</html>