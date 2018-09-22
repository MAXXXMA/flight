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
            // syd->mel
            flights.add(new Flight("QF101", "Sydney", "Melbourne", toDate(day + " 06:00:00"), toDate(day + " 7:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF102", "Sydney", "Melbourne", toDate(day + " 06:30:00"), toDate(day + " 08:05:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF103", "Sydney", "Melbourne", toDate(day + " 06:45:00"), toDate(day + " 08:20:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF104", "Sydney", "Melbourne", toDate(day + " 07:00:00"), toDate(day + " 08:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF105", "Sydney", "Melbourne", toDate(day + " 07:15:00"), toDate(day + " 08:50:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF106", "Sydney", "Melbourne", toDate(day + " 07:30:00"), toDate(day + " 09:05:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Sydney", "Melbourne", toDate(day + " 08:00:00"), toDate(day + " 09:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF108", "Sydney", "Melbourne", toDate(day + " 08:30:00"), toDate(day + " 10:00:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF109", "Sydney", "Melbourne", toDate(day + " 08:45:00"), toDate(day + " 10:20:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF110", "Sydney", "Melbourne", toDate(day + " 09:00:00"), toDate(day + " 10:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF111", "Sydney", "Melbourne", toDate(day + " 09:30:00"), toDate(day + " 11:05:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF112", "Sydney", "Melbourne", toDate(day + " 10:00:00"), toDate(day + " 11:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF113", "Sydney", "Melbourne", toDate(day + " 10:30:00"), toDate(day + " 12:05:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF114", "Sydney", "Melbourne", toDate(day + " 11:00:00"), toDate(day + " 12:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF115", "Sydney", "Melbourne", toDate(day + " 11:30:00"), toDate(day + " 13:05:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Sydney", "Melbourne", toDate(day + " 12:00:00"), toDate(day + " 13:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF117", "Sydney", "Melbourne", toDate(day + " 12:30:00"), toDate(day + " 14:05:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF118", "Sydney", "Melbourne", toDate(day + " 13:00:00"), toDate(day + " 14:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF119", "Sydney", "Melbourne", toDate(day + " 13:30:00"), toDate(day + " 15:05:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Sydney", "Melbourne", toDate(day + " 14:00:00"), toDate(day + " 15:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF121", "Sydney", "Melbourne", toDate(day + " 14:30:00"), toDate(day + " 16:05:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF122", "Sydney", "Melbourne", toDate(day + " 15:00:00"), toDate(day + " 16:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF123", "Sydney", "Melbourne", toDate(day + " 15:15:00"), toDate(day + " 16:45:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF124", "Sydney", "Melbourne", toDate(day + " 15:30:00"), toDate(day + " 17:05:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF125", "Sydney", "Melbourne", toDate(day + " 16:00:00"), toDate(day + " 17:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF126", "Sydney", "Melbourne", toDate(day + " 16:15:00"), toDate(day + " 17:50:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF127", "Sydney", "Melbourne", toDate(day + " 16:30:00"), toDate(day + " 18:05:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF128", "Sydney", "Melbourne", toDate(day + " 17:00:00"), toDate(day + " 18:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF129", "Sydney", "Melbourne", toDate(day + " 17:15:00"), toDate(day + " 18:50:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF130", "Sydney", "Melbourne", toDate(day + " 17:30:00"), toDate(day + " 19:05:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF131", "Sydney", "Melbourne", toDate(day + " 17:45:00"), toDate(day + " 19:20:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Sydney", "Melbourne", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF133", "Sydney", "Melbourne", toDate(day + " 18:15:00"), toDate(day + " 19:50:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF134", "Sydney", "Melbourne", toDate(day + " 18:30:00"), toDate(day + " 20:05:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF135", "Sydney", "Melbourne", toDate(day + " 19:00:00"), toDate(day + " 20:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF136", "Sydney", "Melbourne", toDate(day + " 19:15:00"), toDate(day + " 20:50:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF137", "Sydney", "Melbourne", toDate(day + " 19:30:00"), toDate(day + " 21:05:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF138", "Sydney", "Melbourne", toDate(day + " 19:45:00"), toDate(day + " 21:20:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF139", "Sydney", "Melbourne", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF140", "Sydney", "Melbourne", toDate(day + " 20:35:00"), toDate(day + " 22:05:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF141", "Sydney", "Melbourne", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF142", "Sydney", "Melbourne", toDate(day + " 22:05:00"), toDate(day + " 23:40:00"), 100, 20, 99, 199));
            //end syd->mel
            //syd -> ade
            flights.add(new Flight("QF101", "Sydney", "Adelaide", toDate(day + " 07:00:00"), toDate(day + " 8:40:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Sydney", "Adelaide", toDate(day + " 12:35:00"), toDate(day + " 14:15:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Sydney", "Adelaide", toDate(day + " 18:35:00"), toDate(day + " 20:15:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF141", "Sydney", "Adelaide", toDate(day + " 20:35:00"), toDate(day + " 22:15:00"), 100, 20, 99, 199));
            // end syd->ade
            
            //syd->gold coast
            flights.add(new Flight("QF101", "Sydney", "Gold Coast", toDate(day + " 09:45:00"), toDate(day + " 11:10:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF112", "Sydney", "Gold Coast", toDate(day + " 11:20:00"), toDate(day + " 12:45:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Sydney", "Gold Coast", toDate(day + " 13:55:00"), toDate(day + " 15:20:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Sydney", "Gold Coast", toDate(day + " 19:20:00"), toDate(day + " 20:45:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF125", "Sydney", "Gold Coast", toDate(day + " 20:50:00"), toDate(day + " 22:15:00"), 100, 20, 99, 199));
            //end syd->gold coast
            
            // syd -> perth
            flights.add(new Flight("QF101", "Sydney", "Perth", toDate(day + " 06:25:00"), toDate(day + " 9:30:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Sydney", "Perth", toDate(day + " 12:55:00"), toDate(day + " 16:00:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Sydney", "Perth", toDate(day + " 17:35:00"), toDate(day + " 20:20:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF141", "Sydney", "Perth", toDate(day + " 19:45:00"), toDate(day + " 22:30:00"), 100, 20, 99, 199));
            //end syd->perth
            
            // syd ->can
            flights.add(new Flight("QF101", "Sydney", "Cairns", toDate(day + " 09:30:00"), toDate(day + " 12:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Sydney", "Cairns", toDate(day + " 13:05:00"), toDate(day + " 16:15:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Sydney", "Cairns", toDate(day + " 19:50:00"), toDate(day + " 23:00:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Sydney", "Cairns", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end syd->can
            
            //syd->dar
            flights.add(new Flight("QF101", "Sydney", "Darwin", toDate(day + " 09:20:00"), toDate(day + " 13:30:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Sydney", "Darwin", toDate(day + " 20:20:00"), toDate(day + " 23:55:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF132", "Sydney", "Darwin", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Sydney", "Darwin", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end syd->dar
            
            //mel->syd
            flights.add(new Flight("QF101", "Melbourne", "Sydney", toDate(day + " 06:00:00"), toDate(day + " 7:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Melbourne", "Sydney", toDate(day + " 08:00:00"), toDate(day + " 09:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF112", "Melbourne", "Sydney", toDate(day + " 10:00:00"), toDate(day + " 11:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Melbourne", "Sydney", toDate(day + " 12:00:00"), toDate(day + " 13:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Melbourne", "Sydney", toDate(day + " 14:00:00"), toDate(day + " 15:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF125", "Melbourne", "Sydney", toDate(day + " 16:00:00"), toDate(day + " 17:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Melbourne", "Sydney", toDate(day + " 18:00:00"), toDate(day + " 19:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF139", "Melbourne", "Sydney", toDate(day + " 20:00:00"), toDate(day + " 21:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF141", "Melbourne", "Sydney", toDate(day + " 21:00:00"), toDate(day + " 22:25:00"), 100, 20, 99, 199));
            //end mel->syd
            
            //mel->ade
            flights.add(new Flight("QF101", "Melbourne", "Adelaide", toDate(day + " 06:40:00"), toDate(day + " 7:30:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Melbourne", "Adelaide", toDate(day + " 11:35:00"), toDate(day + " 12:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Melbourne", "Adelaide", toDate(day + " 17:45:00"), toDate(day + " 18:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF139", "Melbourne", "Adelaide", toDate(day + " 20:40:00"), toDate(day + " 21:30:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Melbourne", "Adelaide", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end mel->ade
            
            //mel-> gold coast
            flights.add(new Flight("QF101", "Melbourne", "Gold Coast", toDate(day + " 10:00:00"), toDate(day + " 12:05:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Melbourne", "Gold Coast", toDate(day + " 12:30:00"), toDate(day + " 14:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Melbourne", "Gold Coast", toDate(day + " 15:00:00"), toDate(day + " 17:05:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Melbourne", "Gold Coast", toDate(day + " 17:30:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF125", "Melbourne", "Gold Coast", toDate(day + " 21:00:00"), toDate(day + " 23:05:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF132", "Melbourne", "Gold Coast", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF139", "Melbourne", "Gold Coast", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Melbourne", "Gold Coast", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end mel-> gold coast
            
            //mel -> perth
            flights.add(new Flight("QF101", "Melbourne", "Perth", toDate(day + " 06:30:00"), toDate(day + " 8:40:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Melbourne", "Perth", toDate(day + " 09:05:00"), toDate(day + " 11:15:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Melbourne", "Perth", toDate(day + " 11:35:00"), toDate(day + " 13:45:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF125", "Melbourne", "Perth", toDate(day + " 15:15:00"), toDate(day + " 17:15:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF139", "Melbourne", "Perth", toDate(day + " 19:10:00"), toDate(day + " 21:20:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF141", "Melbourne", "Perth", toDate(day + " 20:35:00"), toDate(day + " 22:45:00"), 100, 20, 99, 199));
            //end mel->perth
            
            //mel->car
            flights.add(new Flight("QF101", "Melbourne", "Cairns", toDate(day + " 13:15:00"), toDate(day + " 16:30:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Melbourne", "Cairns", toDate(day + " 18:55:00"), toDate(day + " 22:20:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF132", "Melbourne", "Cairns", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Melbourne", "Cairns", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end mel->car
            
            //mel->dar
            flights.add(new Flight("QF101", "Melbourne", "Darwin", toDate(day + " 08:45:00"), toDate(day + " 12:45:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Melbourne", "Darwin", toDate(day + " 13:25:00"), toDate(day + " 18:05:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Melbourne", "Darwin", toDate(day + " 15:00:00"), toDate(day + " 19:00:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF141", "Melbourne", "Darwin", toDate(day + " 19:35:00"), toDate(day + " 23:35:00"), 100, 20, 99, 199));
            //end mel->dar
            
            //ade -> syd
            flights.add(new Flight("QF101", "Adelaide", "Sydney", toDate(day + " 06:00:00"), toDate(day + " 8:20:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Adelaide", "Sydney", toDate(day + " 11:00:00"), toDate(day + " 13:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Adelaide", "Sydney", toDate(day + " 17:25:00"), toDate(day + " 19:40:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF141", "Adelaide", "Sydney", toDate(day + " 18:55:00"), toDate(day + " 21:15:00"), 100, 20, 99, 199));
            //end ade ->syd
            
            //ade ->mel
            flights.add(new Flight("QF101", "Adelaide", "Melbourne", toDate(day + " 06:00:00"), toDate(day + " 7:50:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Adelaide", "Melbourne", toDate(day + " 11:40:00"), toDate(day + " 13:30:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Adelaide", "Melbourne", toDate(day + " 18:05:00"), toDate(day + " 19:55:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF141", "Adelaide", "Melbourne", toDate(day + " 20:00:00"), toDate(day + " 21:50:00"), 100, 20, 99, 199));
            //end ade->mel
            
            //ade -> gold coast
            flights.add(new Flight("QF101", "Adelaide", "Gold Coast", toDate(day + " 12:00:00"), toDate(day + " 14:45:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF116", "Adelaide", "Gold Coast", toDate(day + " 13:55:00"), toDate(day + " 13:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Adelaide", "Gold Coast", toDate(day + " 18:10:00"), toDate(day + " 21:25:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Adelaide", "Gold Coast", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end ade ->gold coast
            
            //ade -> perth
            flights.add(new Flight("QF101", "Adelaide", "Perth", toDate(day + " 06:15:00"), toDate(day + " 8:10:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Adelaide", "Perth", toDate(day + " 11:50:00"), toDate(day + " 13:45:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Adelaide", "Perth", toDate(day + " 17:20:00"), toDate(day + " 19:15:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Adelaide", "Perth", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));

            //end ade->perth
            
            //ade->car
            flights.add(new Flight("QF101", "Adelaide", "Cairns", toDate(day + " 07:45:00"), toDate(day + " 11:15:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF116", "Adelaide", "Cairns", toDate(day + " 12:00:00"), toDate(day + " 13:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Adelaide", "Cairns", toDate(day + " 18:45:00"), toDate(day + " 22:15:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Adelaide", "Cairns", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end ade ->car
            
            //ade->dar
            flights.add(new Flight("QF101", "Adelaide", "Darwin", toDate(day + " 08:00:00"), toDate(day + " 11:45:00"), 100, 20, 99, 199));
           // flights.add(new Flight("QF116", "Adelaide", "Darwin", toDate(day + " 12:00:00"), toDate(day + " 13:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Adelaide", "Darwin", toDate(day + " 18:00:00"), toDate(day + " 21:40:00"), 100, 20, 99, 199));
           // flights.add(new Flight("QF141", "Adelaide", "Darwin", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end ade->dar
            
            //car->syd
            flights.add(new Flight("QF101", "Cairns", "Sydney", toDate(day + " 06:05:00"), toDate(day + " 9:00:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Cairns", "Sydney", toDate(day + " 13:35:00"), toDate(day + " 16:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Cairns", "Sydney", toDate(day + " 16:55:00"), toDate(day + " 19:55:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF139", "Cairns", "Sydney", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Cairns", "Sydney", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end car ->syd
            
            //car ->mel
            flights.add(new Flight("QF101", "Cairns", "Melbourne", toDate(day + " 13:15:00"), toDate(day + " 16:40:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Cairns", "Melbourne", toDate(day + " 16:55:00"), toDate(day + " 22:20:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Cairns", "Melbourne", toDate(day + " 21:00:00"), toDate(day + " 23:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF139", "Cairns", "Melbourne", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Cairns", "Melbourne", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end car->mel
            
            //car ->gc
            flights.add(new Flight("QF101", "Cairns", "Gold Coast", toDate(day + " 09:10:00"), toDate(day + " 11:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Cairns", "Gold Coast", toDate(day + " 14:55:00"), toDate(day + " 17:10:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF125", "Cairns", "Gold Coast", toDate(day + " 19:00:00"), toDate(day + " 21:15:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF139", "Cairns", "Gold Coast", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Cairns", "Gold Coast", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end car->gc
            
            //car ->perth
            flights.add(new Flight("QF101", "Cairns", "Perth", toDate(day + " 12:00:00"), toDate(day + " 15:10:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Cairns", "Perth", toDate(day + " 20:10:00"), toDate(day + " 23:20:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF116", "Cairns", "Perth", toDate(day + " 12:00:00"), toDate(day + " 13:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF120", "Cairns", "Perth", toDate(day + " 14:00:00"), toDate(day + " 15:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF139", "Cairns", "Perth", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Cairns", "Perth", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end car -> perth
            
            //car ->dar
            flights.add(new Flight("QF101", "Cairns", "Darwin", toDate(day + " 09:30:00"), toDate(day + " 11:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Cairns", "Darwin", toDate(day + " 15:10:00"), toDate(day + " 17:15:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF120", "Cairns", "Darwin", toDate(day + " 14:00:00"), toDate(day + " 15:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF132", "Cairns", "Darwin", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Cairns", "Darwin", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end car ->dar
            
            //car ->ade
            flights.add(new Flight("QF101", "Cairns", "Adelaide", toDate(day + " 11:45:00"), toDate(day + " 14:30:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Cairns", "Adelaide", toDate(day + " 16:15:00"), toDate(day + " 17:00:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF125", "Cairns", "Adelaide", toDate(day + " 16:00:00"), toDate(day + " 17:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF132", "Cairns", "Adelaide", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Cairns", "Adelaide", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end car ->ade
            
            //perth->syd
            flights.add(new Flight("QF101", "Perth", "Sydney", toDate(day + " 06:15:00"), toDate(day + " 12:20:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF112", "Perth", "Sydney", toDate(day + " 09:45:00"), toDate(day + " 15:50:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Perth", "Sydney", toDate(day + " 12:30:00"), toDate(day + " 18:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF125", "Perth", "Sydney", toDate(day + " 14:30:00"), toDate(day + " 20:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF139", "Perth", "Sydney", toDate(day + " 16:25:00"), toDate(day + " 22:25:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Perth", "Sydney", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end perth->syd
            
            //perth->mel
            flights.add(new Flight("QF101", "Perth", "Melbourne", toDate(day + " 06:05:00"), toDate(day + " 11:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF112", "Perth", "Melbourne", toDate(day + " 08:10:00"), toDate(day + " 13:40:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Perth", "Melbourne", toDate(day + " 10:30:00"), toDate(day + " 16:00:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Perth", "Melbourne", toDate(day + " 14:30:00"), toDate(day + " 19:55:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Perth", "Melbourne", toDate(day + " 17:45:00"), toDate(day + " 23:15:00"), 100, 20, 99, 199));
           //flights.add(new Flight("QF141", "Perth", "Melbourne", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end perth->mel
            
            //perth->gc
            //flights.add(new Flight("QF101", "Perth", "Gold Coast", toDate(day + " 07:00:00"), toDate(day + " 16:00:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Perth", "Gold Coast", toDate(day + " 08:00:00"), toDate(day + " 11:30:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Perth", "Gold Coast", toDate(day + " 19:30:00"), toDate(day + " 23:00:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF125", "Perth", "Gold Coast", toDate(day + " 16:00:00"), toDate(day + " 17:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF139", "Perth", "Gold Coast", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
           // flights.add(new Flight("QF141", "Perth", "Gold Coast", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end perth->gc
            
            //perth->ade
            flights.add(new Flight("QF101", "Perth", "Adelaide", toDate(day + " 06:40:00"), toDate(day + " 11:00:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Perth", "Adelaide", toDate(day + " 08:50:00"), toDate(day + " 13:10:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Perth", "Adelaide", toDate(day + " 11:00:00"), toDate(day + " 15:20:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF125", "Perth", "Adelaide", toDate(day + " 14:35:00"), toDate(day + " 18:55:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Perth", "Adelaide", toDate(day + " 19:00:00"), toDate(day + " 23:20:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Perth", "Adelaide", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end perth->ade
            
            //perth->car
            flights.add(new Flight("QF101", "Perth", "Cairns", toDate(day + " 08:00:00"), toDate(day + " 14:15:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Perth", "Cairns", toDate(day + " 13:00:00"), toDate(day + " 19:15:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF132", "Perth", "Cairns", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF141", "Perth", "Cairns", toDate(day + " 16:20:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end perth->car
            
            //perth->dar
            flights.add(new Flight("QF101", "Perth", "Darwin", toDate(day + " 09:00:00"), toDate(day + " 14:00:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Perth", "Darwin", toDate(day + " 12:00:00"), toDate(day + " 17:05:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Perth", "Darwin", toDate(day + " 17:00:00"), toDate(day + " 22:00:00"), 100, 20, 99, 199));
           // flights.add(new Flight("QF141", "Perth", "Darwin", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end perth->dar
            
            //dar->syd
            flights.add(new Flight("QF101", "Darwin", "Sydney", toDate(day + " 05:15:00"), toDate(day + " 11:20:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Darwin", "Sydney", toDate(day + " 09:45:00"), toDate(day + " 15:50:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF132", "Darwin", "Sydney", toDate(day + " 12:30:00"), toDate(day + " 18:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF141", "Darwin", "Sydney", toDate(day + " 16:20:00"), toDate(day + " 22:25:00"), 100, 20, 99, 199));
            //end dar->syd
            
            //dar->mel
            flights.add(new Flight("QF101", "Darwin", "Melbourne", toDate(day + " 06:05:00"), toDate(day + " 11:00:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Darwin", "Melbourne", toDate(day + " 13:25:00"), toDate(day + " 18:05:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF112", "Darwin", "Melbourne", toDate(day + " 18:00:00"), toDate(day + " 23:05:00"), 100, 20, 99, 199));            
            //flights.add(new Flight("QF125", "Darwin", "Melbourne", toDate(day + " 16:00:00"), toDate(day + " 17:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF132", "Darwin", "Melbourne", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Darwin", "Melbourne", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end dar->mel
            
            //dar->car
            //flights.add(new Flight("QF101", "Darwin", "Cairns", toDate(day + " 18:00:00"), toDate(day + " 21:00:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Darwin", "Cairns", toDate(day + " 12:00:00"), toDate(day + " 15:00:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF112", "Darwin", "Cairns", toDate(day + " 18:00:00"), toDate(day + " 21:00:00"), 100, 20, 99, 199));
           // flights.add(new Flight("QF132", "Darwin", "Cairns", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Darwin", "Cairns", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end dar->car
            
            //dar->ade
            // flights.add(new Flight("QF101", "Darwin", "Adelaide", toDate(day + " 06:00:00"), toDate(day + " 7:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Darwin", "Adelaide", toDate(day + " 12:25:00"), toDate(day + " 16:00:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Darwin", "Adelaide", toDate(day + " 15:00:00"), toDate(day + " 19:00:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF139", "Darwin", "Adelaide", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Darwin", "Adelaide", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end dar->ade
            
            //dar->perth
            flights.add(new Flight("QF101", "Darwin", "Perth", toDate(day + " 06:30:00"), toDate(day + " 8:55:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Darwin", "Perth", toDate(day + " 12:00:00"), toDate(day + " 14:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF112", "Darwin", "Perth", toDate(day + " 14:40:00"), toDate(day + " 17:05:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF116", "Darwin", "Perth", toDate(day + " 12:00:00"), toDate(day + " 13:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF132", "Darwin", "Perth", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Darwin", "Perth", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end dar->perth
            
            //dar->gc
            flights.add(new Flight("QF101", "Darwin", "Gold Coast", toDate(day + " 12:00:00"), toDate(day + " 15:30:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF112", "Darwin", "Gold Coast", toDate(day + " 15:00:00"), toDate(day + " 18:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF116", "Darwin", "Gold Coast", toDate(day + " 12:00:00"), toDate(day + " 13:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF120", "Darwin", "Gold Coast", toDate(day + " 14:00:00"), toDate(day + " 15:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF139", "Darwin", "Gold Coast", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Darwin", "Gold Coast", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end dar->gc
            
            //gc->syd
            flights.add(new Flight("QF101", "Gold Coast", "Sydney", toDate(day + " 07:55:00"), toDate(day + " 9:25:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Gold Coast", "Sydney", toDate(day + " 11:45:00"), toDate(day + " 13:15:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF112", "Gold Coast", "Sydney", toDate(day + " 13:25:00"), toDate(day + " 14:55:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Gold Coast", "Sydney", toDate(day + " 15:55:00"), toDate(day + " 17:25:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF120", "Gold Coast", "Sydney", toDate(day + " 14:00:00"), toDate(day + " 15:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF125", "Gold Coast", "Sydney", toDate(day + " 19:30:00"), toDate(day + " 21:00:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF132", "Gold Coast", "Sydney", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF139", "Gold Coast", "Sydney", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Gold Coast", "Sydney", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            //end gc->syd
            
            // gc- mel
            flights.add(new Flight("QF101", "Gold Coast", "Melbourne", toDate(day + " 07:30:00"), toDate(day + " 9:55:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Gold Coast", "Melbourne", toDate(day + " 08:40:00"), toDate(day + " 11:05:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF112", "Gold Coast", "Melbourne", toDate(day + " 12:35:00"), toDate(day + " 14:50:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Gold Coast", "Melbourne", toDate(day + " 15:10:00"), toDate(day + " 17:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Gold Coast", "Melbourne", toDate(day + " 17:15:00"), toDate(day + " 19:40:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF125", "Gold Coast", "Melbourne", toDate(day + " 19:00:00"), toDate(day + " 21:25:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF132", "Gold Coast", "Melbourne", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF139", "Gold Coast", "Melbourne", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Gold Coast", "Melbourne", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            // end gc- mel
            
            // gc- per
            //flights.add(new Flight("QF101", "Gold Coast", "Perth", toDate(day + " 08:00:00"), toDate(day + " 7:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Gold Coast", "Perth", toDate(day + " 12:00:00"), toDate(day + " 15:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF125", "Gold Coast", "Perth", toDate(day + " 19:30:00"), toDate(day + " 23:00:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF139", "Gold Coast", "Perth", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Gold Coast", "Perth", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            // gc- per
            
            // gc- cai
            flights.add(new Flight("QF101", "Gold Coast", "Cairns", toDate(day + " 06:05:00"), toDate(day + " 8:30:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Gold Coast", "Cairns", toDate(day + " 12:10:00"), toDate(day + " 15:00:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Gold Coast", "Cairns", toDate(day + " 17:40:00"), toDate(day + " 20:05:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF125", "Gold Coast", "Cairns", toDate(day + " 16:00:00"), toDate(day + " 17:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF139", "Gold Coast", "Cairns", toDate(day + " 20:00:00"), toDate(day + " 21:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Gold Coast", "Cairns", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            // gc -cai
            
            // gc - adel
            //flights.add(new Flight("QF101", "Gold Coast", "Adelaide", toDate(day + " 06:00:00"), toDate(day + " 7:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF107", "Gold Coast", "Adelaide", toDate(day + " 12:00:00"), toDate(day + " 14:15:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Gold Coast", "Adelaide", toDate(day + " 15:55:00"), toDate(day + " 18:05:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF125", "Gold Coast", "Adelaide", toDate(day + " 16:00:00"), toDate(day + " 17:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF132", "Gold Coast", "Adelaide", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
            //flights.add(new Flight("QF141", "Gold Coast", "Adelaide", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            // gc -adel
            
            // gc - darwin
            //flights.add(new Flight("QF101", "Gold Coast", "Darwin", toDate(day + " 06:00:00"), toDate(day + " 7:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF116", "Gold Coast", "Darwin", toDate(day + " 12:00:00"), toDate(day + " 15:35:00"), 100, 20, 99, 199));
            flights.add(new Flight("QF120", "Gold Coast", "Darwin", toDate(day + " 17:15:00"), toDate(day + " 20:50:00"), 100, 20, 99, 199));
           //flights.add(new Flight("QF132", "Gold Coast", "Darwin", toDate(day + " 18:00:00"), toDate(day + " 19:35:00"), 100, 20, 99, 199));
           //flights.add(new Flight("QF141", "Gold Coast", "Darwin", toDate(day + " 21:00:00"), toDate(day + " 22:35:00"), 100, 20, 99, 199));
            // gc- darwin
            
            
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
