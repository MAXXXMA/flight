/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootstrap;

import dao.BookingDao;
import dao.FlightDao;
import dao.UserDao;
import dto.Booking;
import dto.Flight;
import dto.Flights;
import dto.Bookings;
import dto.User;
import dto.Users;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BootstrapData {

    public static Date toDate(String msg) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return formatter.parse(msg);
        } catch (ParseException ex) {
            Logger.getLogger(BootstrapData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String args[]) throws ParseException {

        UserDao userDao = new UserDao();
        FlightDao flightDao = new FlightDao();
        BookingDao bookingDao = new BookingDao();

        userDao.save(new Users());
        flightDao.save(new Flights());
        bookingDao.save(new Bookings());

        List<User> users = new ArrayList<User>();
        users.add(new User("user1@uts.com", "user1", "Tom"));
        users.add(new User("user2@uts.com", "user2", "Bob"));
        users.add(new User("user3@uts.com", "user3", "Jim"));
        users.add(new User("user4@uts.com", "user4", "Jerry"));
        users.add(new User("user5@uts.com", "user5", "Alice"));

        List<Flight> flights = new ArrayList<Flight>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date start = formatter.parse("2018-09-21");
        Date end = formatter.parse("2018-10-21");

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(start);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(end);
        while (calendar.before(endCalendar)) {
            Date now = calendar.getTime();
            String day = formatter.format(now);
            flights.add(new Flight("QF101", "Sydney", "Melbourne", toDate(day + " 08:00:00"), toDate(day + " 10:30:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF102", "Melbourne", "Sydney", toDate(day + " 13:00:00"), toDate(day + " 15:40:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF201", "Sydney", "Cairns", toDate(day + " 14:00:00"), toDate(day + " 17:20:00"), 80, 10, 199, 399));
            flights.add(new Flight("QF202", "Cairns", "Sydney", toDate(day + " 18:00:00"), toDate(day + " 21:10:00"), 80, 10, 199, 399));
            flights.add(new Flight("QF301", "Sydney", "Gold Coast", toDate(day + " 11:00:00"), toDate(day + " 13:15:00"), 60, 20, 89, 149));
            flights.add(new Flight("QF302", "Gold Coast", "Sydney", toDate(day + " 14:00:00"), toDate(day + " 16:20:00"), 60, 20, 99, 199));

            calendar.add(Calendar.DATE, 1);
        }

        List<Booking> bookings = new ArrayList<Booking>();

        bookings.add(new Booking(flights.get(0).getFlightId(), users.get(0).getUserId(), toDate("2018-09-05 08:00:00"), "Economic", 2, flights.get(0).getSeatPrice() * 2));
        bookings.add(new Booking(flights.get(4).getFlightId(), users.get(0).getUserId(), toDate("2018-09-06 08:00:00"), "Economic", 1, flights.get(4).getSeatPrice() * 1));
        bookings.add(new Booking(flights.get(8).getFlightId(), users.get(0).getUserId(), toDate("2018-09-07 08:00:00"), "Economic", 1, flights.get(8).getSeatPrice() * 2));

        for (User user : users) {
            userDao.add(user);
        }

        for (Flight flight : flights) {
            flightDao.add(flight);
        }

        for (Booking booking : bookings) {
            bookingDao.add(booking);
        }

    }
}
