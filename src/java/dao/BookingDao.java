package dao;

import dto.Booking;
import dto.Bookings;

public class BookingDao extends BaseDao {

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
    public void addBooking(Booking booking) {
        Bookings bookings = getAll();
        bookings.addBooking(booking);
        save(bookings);
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
