package dao;

import dto.Booking;
import dto.Bookings;
import java.util.ArrayList;
import java.util.List;

public class BookingDao extends BaseDao {

    private FlightDao flightDao = new FlightDao();
    private UserDao userDao = new UserDao();

    public Booking getBooking(String bookingId) {
        for (Booking u : getAll().getBookings()) {
            if (u.getBookingId().equals(bookingId)) {
                return u;
            }
        }
        return null;
    }

    /**
     * create new booking and store in xml
     *
     * @param booking
     */
    public void add(Booking booking) {
        Bookings bookings = getAll();
        bookings.addBooking(booking);
        save(bookings);
    }

    public List<Booking> getBookingsByUserId(String userId) {
        List<Booking> bookings = new ArrayList<Booking>();
        for (Booking booking : getAll().getBookings()) {
            if (booking.getUserId().equals(userId)) {
                bookings.add(booking);
            }
        }
        return fillBookings(bookings);
    }

    public void remove(String bookingId) {
        int index = -1;
        List<Booking> bookings = getAll().getBookings();
        for (int i = 0; i < bookings.size(); i++) {
            Booking f = bookings.get(i);
            if (f.getFlightId().equals(bookingId)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            bookings.remove(index);
            save(new Bookings(bookings));
        }

    }

    public List<Booking> fillBookings(List<Booking> bookings) {
        for (Booking b : bookings) {
            fillBooking(b);
        }
        return bookings;
    }

    public void fillBooking(Booking booking) {
        booking.setFlight(flightDao.getFlight(booking.getFlightId()));
        booking.setUser(userDao.getUser(booking.getUserId()));
    }

    /**
     * get all bookings
     *
     * @return
     */
    public Bookings getAll() {
        return (Bookings) this.get(Bookings.class);
    }
}
