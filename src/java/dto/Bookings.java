package dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bookings")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bookings {

    @XmlElement(name = "booking")
    private List<Booking> bookings;

    public Bookings() {
        this.bookings = new ArrayList<Booking>();
    }

    public Bookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking p) {
        this.bookings.add(p);
    }

    public int size() {
        return this.bookings.size();
    }
}
