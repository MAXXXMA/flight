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
        <title>Flight System</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <div class="container">

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
                                <dd class="col-8"><fmt:formatDate type = "both" 
                                                dateStyle = "short" timeStyle = "short" value = "${flight.departureDate}" /></dd>
                            </dl>
                            <dl class="row">
                                <dt class="col-4">Arrive</dt>
                                <dd class="col-8"><fmt:formatDate type = "both" 
                                                dateStyle = "short" timeStyle = "short" value = "${flight.arriveDate}" /></dd>
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

                <div class="col-6">
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
                                    <input name="quantity" type="number" min="1" max="200" class="form-control" value="1" required>
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
                if(cc.match(/\d{16}/)) {
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