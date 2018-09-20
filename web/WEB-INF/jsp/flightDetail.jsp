<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="en_AU" />
<!DOCTYPE html">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Flight System</title>
</head>

<body>
    <jsp:include page="header.jsp" />

    <div id="flight-detail-bg"></div>
    <div class="container">

        <div class="flight-list animated bounceIn" style="margin-top:-4rem;">
            <div class="flight-list-item active shadow">
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
                        ${flight.flightNumber}
                        <br>
                        <span class="text-muted">Qantas</span>
                    </div>
                    <div class="col-2 text-right">
                        <i class="fas fa-dollar-sign"></i>
                        ${flight.seatPrice}
                        <br>
                        <span class="text-muted">Economic</span>
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

                        </div>
                        <div class="dot-img"></div>
                    </div>
                </div>
            </div>
        </div>

        <c:if test="${empty sessionScope.user}">
            <div class="row my-3">
                <div class="offset-4 col-4">
                    <a class="btn btn-block btn-info" href="Login?redirectUrl=FlightDetail?flightId=${flight.flightId}">Login now for booking</a>
                </div>
            </div>
        </c:if>

        <h2 class="my-3"><em>${flight.flightNumber}</em></h2>

        <div class="row">
            <div class="col-6">
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
                            <dd class="col-8">
                                <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${flight.departureDate}" />
                            </dd>
                        </dl>
                        <dl class="row">
                            <dt class="col-4">Arrive</dt>
                            <dd class="col-8">
                                <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${flight.arriveDate}" />
                            </dd>
                        </dl>
                        <dl class="row">
                            <dt class="col-4">Seat Price</dt>
                            <dd class="col-8">$ ${flight.seatPrice}</dd>
                        </dl>
                        <dl class="row">
                            <dt class="col-4">First class Seat Price</dt>
                            <dd class="col-8">$ ${flight.firstClassSeatPrice}</dd>
                        </dl>
                    </div>
                </div>
            </div>

            <div class="col-6" style="display:none">
                <c:if test="${not empty param.errorMsg}">
                    <div class="alert alert-danger">${param.errorMsg}</div>
                </c:if>

                <form action="BookFlight" method="post" onsubmit="return validateForm()">
                    <input type="hidden" name="flightId" value="${flight.flightId}">
                    <div class="card mb-3">
                        <div class="card-header bg-info text-white">
                            Book Now
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label>Ticket Quantity</label>
                                <input name="quantity" type="number" min="1" max="200" class="form-control" value="1"
                                    required>
                            </div>
                            <div class="form-group">
                                <label>Seat Type</label>
                                <select class="form-control" name="type">
                                    <option value="Economic">Economic ($ ${flight.seatPrice})</option>
                                    <option value="First class">First class ($ ${flight.firstClassSeatPrice})</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Credit card number</label>
                                <input name="creditcard" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Total price</label>
                                <p><span id="total-price"></span></p>
                            </div>
                            <button type="submit" class="btn btn-info">Book Now</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        var seatPrice = parseFloat('${flight.seatPrice}');
        var firstClassSeatPrice = parseFloat('${flight.firstClassSeatPrice}');
        function updatePrice() {
            var quantity = $('input[name="quantity"]').val();
            var price = 0;
            if ($('select').val() == 'Economic') {
                price = seatPrice;
            } else {
                price = firstClassSeatPrice;
            }
            var totalPrice = quantity * price;
            $('#total-price').text('$ ' + totalPrice.toFixed(2));
        }

        function validateCreditCard() {
            var cc = $('input[name="creditcard"]').val();
            if (cc.match(/\d{16}/)) {
                return true;
            } else {
                return false;
            }
        }

        function validateForm() {
            if (!validateCreditCard()) {
                alert('Credit card need to be 16 digits');
                return false;
            }

            return true;
        }

        $('input, select').change(updatePrice);

        updatePrice();
    </script>
</body>

</html>