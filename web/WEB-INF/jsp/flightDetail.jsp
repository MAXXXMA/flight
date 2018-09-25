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
                        <div class="col-4">
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
                        <div class="col-2 text-right">
                            <i class="fas fa-dollar-sign"></i>
                            ${flight.firstClassSeatPrice}
                            <br>
                            <span class="text-muted">First class</span>
                        </div>
                    </div>

                    <div class="flight-list-item-detail" style="max-height: inherit">
                        <div class="row">
                            <div class="offset-1"></div>
                            <div class="col-5">
                                <span>
                                    <span class="text-muted"><fmt:formatDate type="both" timeStyle="short" value="${flight.departureDate}" /></span>
                                    <b>${flight.fromCity}</b>
                                </span>
                                <p class="my-2 text-muted">Travel Time: ${flight.getDuration()}</p>
                                <span>
                                    <span class="text-muted"><fmt:formatDate type="both" timeStyle="short" value="${flight.arriveDate}" /></span>
                                    <b>${flight.toCity}</b>
                                </span>
                            </div>
                            <div class="col-3">
                                <p class="mb-1">
                                    <span class="text-muted">Economic Seat left:</span> ${flight.seats}
                                </p>                            
                                <p class="mb-1">
                                    <span class="text-muted">First class Seat left:</span> ${flight.firstClassSeats}
                                </p>                            
                            </div>
                            <div class="col-3">
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

            <c:if test="${not empty sessionScope.user}">
                <div class="row animated fadeInUp">

                    <div class="offset-md-2 col-md-8 offset-lg-3 col-lg-6">

                        <c:if test="${not empty param.errorMsg}">
                            <div class="alert alert-danger">${param.errorMsg}</div>
                        </c:if>

                        <form action="BookFlight" method="post" onsubmit="return validateForm()">
                            <input type="hidden" name="flightId" value="${flight.flightId}">
                            <div class="card mb-3 shadow">
                                <div class="card-header bg-info text-white">
                                    Book Now
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label>Ticket Quantity</label>
                                        <input name="quantity" type="number" min="1" max="100" class="form-control" value="1"
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
            </c:if>



        </div>
        <script>
            var seatPrice = parseFloat('${flight.seatPrice}');
            var firstClassSeatPrice = parseFloat('${flight.firstClassSeatPrice}');
            var seats = parseInt('${flight.seats}');
            var firstClassSeats = parseInt('${flight.firstClassSeats}');

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
                    swal({
                        type: 'error',
                        title: 'Oops...',
                        text: 'Credit card need to be 16 digits',
                    })
                    return false;
                }

                var quantity = $('input[name="quantity"]').val();
                if (quantity > 100) {
                    swal({
                        type: 'error',
                        title: 'Oops...',
                        text: 'You can\'t book more than 100 seats at a tim',
                    })
                    return false;
                }
                if ($('select').val() == 'Economic') {
                    if (quantity > seats) {
                        swal({
                            type: 'error',
                            title: 'Oops...',
                            text: 'There are only ' + seats + ' Economic seats left, you can\'t book that many',
                        })
                        return false;
                    }
                } else {
                    if (quantity > firstClassSeats) {
                        swal({
                            type: 'error',
                            title: 'Oops...',
                            text: 'There are only ' + firstClassSeats + ' First class seats left, you can\'t book that many',
                        })
                        return false;
                    }
                }

                return true;
            }

            $('input, select').change(updatePrice);

            updatePrice();
        </script>
    </body>

</html>