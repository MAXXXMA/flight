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

        <c:if test="${not searched}">
            <h4>Suggested trips from Sydney</h4>
            <br>

            <div class="row">
                <div class="col-4">
                    <a href="Index?fromCity=Sydney&toCity=Melbourne">
                        <div class="shadow bg-white">
                            <div class="row">
                                <div class="col-5">
                                    <img class="img-fluid" src="//www.gstatic.com/flights/app/runway_1080.png">
                                </div>
                                <div class="col-7 p-3">
                                    <h4>Melbourne</h4>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>

                <div class="col-4">
                    <a href="Index?fromCity=Sydney&toCity=Cairns">
                        <div class="shadow bg-white">
                            <div class="row">
                                <div class="col-5">
                                    <img class="img-fluid" src="//t2.gstatic.com/images?q=tbn:ANd9GcQYaSS5FaSQGxsIX_5jLIKq-2yFr_Y3135n3e_XV_Hbgng35BDUY7axvnj1HN8NUPvjnGFQheE">
                                </div>
                                <div class="col-7 p-3">
                                    <h4>Cairns</h4>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>

                <div class="col-4">
                    <a href="Index?fromCity=Sydney&toCity=Gold Coast">
                        <div class="shadow bg-white">
                            <div class="row">
                                <div class="col-5">
                                    <img class="img-fluid" src="//www.gstatic.com/flights/app/runway_1080.png">
                                </div>
                                <div class="col-7 p-3">
                                    <h4>Gold Coast</h4>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>

            </div>
        </c:if>


        <c:if test="${searched}">
            <div class="flight-list animated fadeInUp">
                <c:forEach var="flight" items="${flights}">
                    <div class="flight-list-item">
                        <div class="row align-middle align-self-center">
                            <div class="col-1">
                                <img class="flight-logo" src="./images/QF.png" class="img-thumbnail">
                            </div>
                            <div class="col-3">
                                <b>
                                    <fmt:formatDate type="time" timeStyle="short" value="${flight.departureDate}" />
                                    -
                                    <fmt:formatDate type="time" timeStyle="short" value="${flight.arriveDate}" />
                                </b>
                                <br>
                                <span class="text-muted">
                                    <fmt:formatDate type="date" timeStyle="short" value="${flight.departureDate}" />
                                </span>
                            </div>
                            <div class="col-3">
                                ${flight.getDuration()}
                                <br>
                                <span class="text-muted">${flight.fromCity} - ${flight.toCity}</span>
                            </div>
                            <div class="col-2">
                                <a href="FlightDetail?flightId=${flight.flightId}">${flight.flightNumber}</a>
                                <br>
                                <span class="text-muted">Qantas</span>
                            </div>
                            <div class="col-2 text-right">
                                <i class="fas fa-dollar-sign"></i>
                                ${flight.seatPrice}
                                <br>
                                <span class="text-muted">Economic</span>
                            </div>

                            <div class="col-1 text-center v-center">
                                <a class="d-block expand-btn" tabindex="1">
                                    <i class="fa fa-chevron-down"></i>
                                </a>
                            </div>
                        </div>

                        <div class="flight-list-item-detail">
                            <div class="row">
                                <div class="offset-1"></div>
                                <div class="col-7">
                                    <span>
                                        <fmt:formatDate type="both" timeStyle="short" value="${flight.departureDate}" />
                                        <b>${flight.fromCity}</b>
                                    </span>
                                    <p class="my-2 text-muted">Travel Time: ${flight.getDuration()}</p>
                                    <span>
                                        <fmt:formatDate type="both" timeStyle="short" value="${flight.arriveDate}" />
                                        <b>${flight.toCity}</b>
                                    </span>
                                </div>
                                <div class="col-4">
                                    <p class="text-muted mb-1">
                                        <i class="fas fa-ruler-combined mr-2"></i>
                                        Average legroom (79 cm)
                                    </p>
                                    <p class="text-muted mb-1">
                                        <i class="fas fa-wifi mr-2"></i>
                                        Wifi access
                                    </p>

                                    <a class="btn btn-outline-info" href="FlightDetail?flightId=${flight.flightId}">SELECT
                                        FLIGHT</a>
                                </div>
                                <div class="dot-img"></div>
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
            var departure = $('[name=departure]').val();
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
            if (!departure) {
                swal({
                    type: 'error',
                    title: 'Oops...',
                    text: 'Please specify a depature date',
                })
                return false;
            }
            return true;
        }

        $('.expand-btn').click(function (e) {
            var item = $(e.currentTarget).parents('.flight-list-item');
            item.toggleClass('active');
            item.toggleClass('shadow');
        })
    </script>
</body>

</html>