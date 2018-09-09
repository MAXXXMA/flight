package dao;

import dto.Booking;
import dto.Bookings;
import dto.Flight;
import java.util.ArrayList;
import java.util.Date;
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

    public Booking createBooking(String flightId, String userId, int quantity, String type) {
        Flight flight = flightDao.getFlight(flightId);
        double price = flight.getSeatPrice();
        if (type.equals("First class")) {
            price = flight.getfirstClassSeatPrice();
            flight.setFirstClassSeats(flight.getFirstClassSeats() - quantity);
        } else {
            flight.setSeats(flight.getSeats() - quantity);
        }
        Booking booking = new Booking(flightId, userId, new Date(), type, quantity, price * quantity);
        add(booking);

        flightDao.update(flight);
        return booking;
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

    public List<Booking> getBookingsByFlightId(String flightId) {
        List<Booking> bookings = new ArrayList<Booking>();
        for (Booking booking : getAll().getBookings()) {
            if (booking.getFlightId().equals(flightId)) {
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
            if (f.getBookingId().equals(bookingId)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Booking booking = bookings.get(index);
            bookings.remove(index);
            save(new Bookings(bookings));

            Flight flight = flightDao.getFlight(booking.getFlightId());
            if (booking.getType().equals("Economic")) {
                flight.setSeats(flight.getSeats() + booking.getQuantity());
            } else {
                flight.setFirstClassSeats(flight.getFirstClassSeats() + booking.getQuantity());
            }
            flightDao.update(flight);
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

    public List<Booking> getAllBookings() {
        return fillBookings(getAll().getBookings());
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
