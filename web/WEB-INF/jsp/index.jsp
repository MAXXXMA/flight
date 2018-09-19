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

    <div id="search-flight-bg" class="searched-${searched}"></div>

    <div class="container">
        <form action="Index" onsubmit="return validateForm()">
            <div class="text-white p-3 shadow-lg rounded" id="search-flight-form">
                <div class="row">
                    <div class="col-4">
                        <div class="form-group">
                            <label>From City</label>
                            <select class="custom-select" name="fromCity">
                                <option value="">Select</option>
                                <option value="Sydney" ${param.fromCity=='Sydney' ? 'selected' : '' }>Sydney</option>
                                <option value="Melbourne" ${param.fromCity=='Melbourne' ? 'selected' : '' }>Melbourne</option>
                                <option value="Cairns" ${param.fromCity=='Cairns' ? 'selected' : '' }>Cairns</option>
                                <option value="Gold Coast" ${param.fromCity=='Gold Coast' ? 'selected' : '' }>Gold
                                    Coast</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="form-group">
                            <label>To City</label>
                            <select class="custom-select" name="toCity">
                                <option value="">Select</option>
                                <option value="Sydney" ${param.toCity=='Sydney' ? 'selected' : '' }>Sydney</option>
                                <option value="Melbourne" ${param.toCity=='Melbourne' ? 'selected' : '' }>Melbourne</option>
                                <option value="Cairns" ${param.toCity=='Cairns' ? 'selected' : '' }>Cairns</option>
                                <option value="Gold Coast" ${param.toCity=='Gold Coast' ? 'selected' : '' }>Gold Coast</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="form-group">
                            <label>Departure</label>
                            <input type="date" class="form-control" name="departure" value="${param.departure}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" id="search-button-wrapper">
                <div class="col-4 offset-4">
                    <button class="btn btn-success btn-block shadow" type="submit">
                        <i class="fas fa-search mr-1"></i>
                        Search
                    </button>
                </div>
            </div>

        </form>
        <br>

        <c:if test="${searched}">
            <div class="flight-list animated fadeInUp">
                <c:forEach var="flight" items="${flights}">
                    <div class="flight-list-item">
                        <div class="row">
                            <div class="col-3">
                                <img class="flight-logo" src="./images/QF.png" class="img-thumbnail">
                            </div>
                            <div class="col-3">${flight.flightNumber}</div>
                            <div class="col-3">${flight.fromCity}</div>
                            <div class="col-3">${flight.toCity}</div>
                            <div class="col-3">
                                ${flight.getDuration()}
                                <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${flight.departureDate}" />
                                <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${flight.arriveDate}" />
                                <a href="FlightDetail?flightId=${flight.flightId}" class="btn btn-primary">Detail</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>

    <br>

    <script>
        function validateForm() {
            var fromCity = $('[name="fromCity"]').val();
            var toCity = $('[name="toCity"]').val();
            if (!fromCity && !toCity) {
                swal({
                    type: 'error',
                    title: 'Oops...',
                    text: 'Please specify either a from city or to city.',
                })
                return false;
            }
            if (fromCity == toCity && fromCity) {
                swal({
                    type: 'error',
                    title: 'Oops...',
                    text: 'From city and to city cannot be the same!',
                })
                return false;
            }
            return true;
        }
    </script>
</body>

</html>