/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Booking;
import dto.Flight;
import dto.User;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookingDaoTest {

    private FlightDao flightDao = new FlightDao();
    private UserDao userDao = new UserDao();
    private BookingDao bookingDao = new BookingDao();
    Booking newBooking;
    User newUser;
    Flight newFlight;

    public BookingDaoTest() {

    }

    @Before
    public void setUp() {

        newFlight = new Flight();
        newFlight.setFromCity("Sydney");
        newFlight.setToCity("Gold Coast");
        newFlight.setDepartureDate(new Date());
        newFlight.setArriveDate(new Date());
        flightDao.add(newFlight);

        newUser = new User();
        newUser.setEmail(UUID.randomUUID().toString() + "@uts.com");
        newUser.setName("test user");
        newUser.setPassword("password");
        userDao.add(newUser);

        newBooking = new Booking();
        newBooking.setFlightId(newFlight.getFlightId());
        newBooking.setUserId(newUser.getUserId());
        newBooking.setType("First Class");
        newBooking.setQuantity(1);
    }

    @After
    public void tearDown() {
        bookingDao.remove(newBooking.getBookingId());
        flightDao.remove(newFlight.getFlightId());
        userDao.remove(newUser.getUserId());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testAdd() {
        String bookingId = newBooking.getBookingId();
        bookingDao.add(newBooking);
        Booking fetchedBooking = bookingDao.getBooking(bookingId);
        assertTrue(fetchedBooking.getFlightId().equals(newBooking.getFlightId()));
        assertTrue(fetchedBooking.getUserId().equals(newBooking.getUserId()));
        assertTrue(fetchedBooking.getBookingId().equals(newBooking.getBookingId()));
    }

    @Test
    public void testGet() {
        String bookingId = newBooking.getBookingId();
        bookingDao.add(newBooking);
        Booking fetchedBooking = bookingDao.getBooking(bookingId);
        assertTrue(fetchedBooking.getFlightId().equals(newBooking.getFlightId()));
        assertTrue(fetchedBooking.getUserId().equals(newBooking.getUserId()));
        assertTrue(fetchedBooking.getBookingId().equals(newBooking.getBookingId()));
    }

    @Test
    public void testGetAll() {
        bookingDao.add(newBooking);
        List<Booking> bookings = bookingDao.getAllBookings();
        assertTrue(bookings.size() > 0);
    }

    @Test
    public void testRemove() {
        String bookingId = newBooking.getBookingId();
        bookingDao.remove(bookingId);
        Booking fetchedBooking = bookingDao.getBooking(bookingId);
        assertTrue(fetchedBooking == null);
    }

    @Test
    public void testGetBookingsByFlightId() {
        bookingDao.add(newBooking);
        List<Booking> bookings = bookingDao.getBookingsByFlightId(newFlight.getFlightId());
        assertTrue(bookings.size() == 1);
    }

    @Test
    public void testGetBookingsByUserId() {
        bookingDao.add(newBooking);
        List<Booking> bookings = bookingDao.getBookingsByUserId(newUser.getUserId());
        assertTrue(bookings.size() == 1);
    }

}
