package dto;

import java.util.Date;
import java.util.UUID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight {

    @XmlElement
    private String flightId;
    @XmlElement
    private String flightNumber;
    @XmlElement
    private String fromCity;
    @XmlElement
    private String toCity;
    @XmlElement
    private Date departureDate;
    @XmlElement
    private Date arriveDate;
    @XmlElement
    private int seats;
    @XmlElement
    private int firstClassSeats;
    @XmlElement
    private double seatPrice;
    @XmlElement
    private double firstClassSeatsPrice;

    public Flight() {
        this.flightId = UUID.randomUUID().toString().substring(0, 8);
    }

    public Flight(String flightNumber, String fromCity, String toCity, Date departureDate, Date arriveDate, int seats, int firstClassSeats, double seatPrice, double firstClassSeatsPrice) {

        this();
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.departureDate = departureDate;
        this.arriveDate = arriveDate;
        this.seats = seats;
        this.firstClassSeats = firstClassSeats;
        this.seatPrice = seatPrice;
        this.firstClassSeatsPrice = firstClassSeatsPrice;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getFirstClassSeats() {
        return firstClassSeats;
    }

    public void setFirstClassSeats(int firstClassSeats) {
        this.firstClassSeats = firstClassSeats;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }

    public double getFirstClassSeatsPrice() {
        return firstClassSeatsPrice;
    }

    public void setFirstClassSeatsPrice(double firstClassSeatsPrice) {
        this.firstClassSeatsPrice = firstClassSeatsPrice;
    }

}
