package dto;

import java.util.Date;
import java.util.UUID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Booking {

    @XmlElement
    private String flightId;
    @XmlElement
    private String userId;
    @XmlElement
    private String bookingId;
    @XmlElement
    private Date created;
    @XmlElement
    private String type;
    @XmlElement
    private int quantity;
    @XmlElement
    private double price;
    private Flight flight;
    private User user;

    public Booking() {
        this.bookingId = UUID.randomUUID().toString().substring(0, 8);
        this.created = new Date();
    }

    public Booking(String flightId, String userId, Date created, String type, int quantity, double price) {
        this();
        this.flightId = flightId;
        this.userId = userId;
        this.created = created;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
