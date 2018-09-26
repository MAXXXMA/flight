package dao;

import dto.Booking;
import dto.Bookings;
import dto.Flight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingDao extends BaseDao {

    private FlightDao flightDao = new FlightDao();
    private UserDao userDao = new UserDao();

//  `bookingId` VARCHAR(45) NOT NULL,
//  `userId` VARCHAR(45) NOT NULL,
//  `flightId` VARCHAR(45) NOT NULL,
//  `created` DATETIME NULL,
//  `type` VARCHAR(45) NULL,
//  `quantity` INT NULL,
//  `price` DOUBLE NULL,
    private Booking extractBooking(ResultSet rs) throws SQLException {
        Booking booking = new Booking();
        booking.setBookingId(rs.getString("bookingId"));
        booking.setFlightId(rs.getString("flightId"));
        booking.setUserId(rs.getString("userId"));
        booking.setCreated(rs.getDate("created"));
        booking.setType(rs.getString("type"));
        booking.setQuantity(rs.getInt("quantity"));
        booking.setPrice(rs.getDouble("price"));
        return booking;
    }

    public Booking getBooking(String bookingId) {
        Connection conn = getConnection();
        Booking booking = null;
        try {
            String sql = "select * from Booking where bookingId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, bookingId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                booking = extractBooking(rs);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return booking;
    }

    /**
     * create new booking and store in xml
     *
     * @param booking
     */
    public void add(Booking booking) {
        Connection conn = getConnection();
        try {
            //  `bookingId` VARCHAR(45) NOT NULL,
            //  `userId` VARCHAR(45) NOT NULL,
            //  `flightId` VARCHAR(45) NOT NULL,
            //  `created` DATETIME NULL,
            //  `type` VARCHAR(45) NULL,
            //  `quantity` INT NULL,
            //  `price` DOUBLE NULL,
            String sql = "insert into Booking values (?, ?, ?, ?, ? , ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, booking.getBookingId());
            preparedStatement.setString(2, booking.getUserId());
            preparedStatement.setString(3, booking.getFlightId());
            preparedStatement.setDate(4, new java.sql.Date(booking.getCreated().getTime()));
            preparedStatement.setString(5, booking.getType());
            preparedStatement.setInt(6, booking.getQuantity());
            preparedStatement.setDouble(7, booking.getPrice());
            preparedStatement.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        List<Booking> bookings = new ArrayList<Booking>();
        Connection conn = getConnection();
        try {
            String sql = "select * from Booking";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                bookings.add(extractBooking(rs));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FlightDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fillBookings(bookings);
    }

}
