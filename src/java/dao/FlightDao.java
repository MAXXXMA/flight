package dao;

import dto.Flight;
import dto.Flights;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlightDao extends BaseDao {

    private Flight extractFlight(ResultSet rs) throws SQLException {
        Flight flight = new Flight();
        flight.setFlightId(rs.getString("flightId"));
        flight.setFlightNumber(rs.getString("flightNumber"));
        flight.setFromCity(rs.getString("fromCity"));
        flight.setToCity(rs.getString("toCity"));
        flight.setSeats(rs.getInt("seats"));
        flight.setFirstClassSeats(rs.getInt("firstClassSeats"));
        flight.setSeatPrice(rs.getDouble("seatPrice"));
        flight.setfirstClassSeatPrice(rs.getDouble("firstClassSeatPrice"));
        flight.setDepartureDate(rs.getDate("departureDate"));
        flight.setArriveDate(rs.getDate("arriveDate"));
        return flight;
    }

    public Flight getFlight(String flightId) {
        Connection conn = getConnection();
        Flight flight = null;
        try {
            String sql = "select * from Flight where flightId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, flightId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                flight = extractFlight(rs);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FlightDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flight;
    }

    /**
     * create new flight and store in xml
     *
     * @param flight
     */
    public void add(Flight flight) {
        Connection conn = getConnection();
        try {
//            `flightId` VARCHAR(45) NOT NULL,
//            `flightNumber` VARCHAR(45) NULL,
//            `fromCity` VARCHAR(45) NULL,
//            `toCity` VARCHAR(45) NULL,
//            `departureDate` DATETIME NULL,
//            `arriveDate` DATETIME NULL,
//            `seats` INT NULL,
//            `firstClassSeats` INT NULL,
//            `seatPrice` DOUBLE NULL,
//            `firstClassSeatPrice` DOUBLE NULL,
            String sql = "insert into Flight values (?, ?, ?, ?, ? ,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, flight.getFlightId());
            preparedStatement.setString(2, flight.getFlightNumber());
            preparedStatement.setString(3, flight.getFromCity());
            preparedStatement.setString(4, flight.getToCity());
            preparedStatement.setDate(5, new java.sql.Date(flight.getDepartureDate().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(flight.getArriveDate().getTime()));
            preparedStatement.setInt(7, flight.getSeats());
            preparedStatement.setInt(8, flight.getFirstClassSeats());
            preparedStatement.setDouble(9, flight.getSeatPrice());
            preparedStatement.setDouble(10, flight.getfirstClassSeatPrice());
            preparedStatement.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FlightDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Flight flight) {
        Connection conn = getConnection();
        try {
//            `flightId` VARCHAR(45) NOT NULL,
//            `flightNumber` VARCHAR(45) NULL,
//            `fromCity` VARCHAR(45) NULL,
//            `toCity` VARCHAR(45) NULL,
//            `departureDate` DATETIME NULL,
//            `arriveDate` DATETIME NULL,
//            `seats` INT NULL,
//            `firstClassSeats` INT NULL,
//            `seatPrice` DOUBLE NULL,
//            `firstClassSeatPrice` DOUBLE NULL,
            String sql = "update Flight set flightNumber = ?, fromCity = ?, toCity = ?, departureDate = ?, arriveDate = ?, seats = ?, firstClassSeats = ?, seatPrice = ?, firstClassSeatPrice = ? where flightId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(10, flight.getFlightId());
            preparedStatement.setString(1, flight.getFlightNumber());
            preparedStatement.setString(2, flight.getFromCity());
            preparedStatement.setString(3, flight.getToCity());
            preparedStatement.setDate(4, new java.sql.Date(flight.getDepartureDate().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(flight.getArriveDate().getTime()));
            preparedStatement.setInt(6, flight.getSeats());
            preparedStatement.setInt(7, flight.getFirstClassSeats());
            preparedStatement.setDouble(8, flight.getSeatPrice());
            preparedStatement.setDouble(9, flight.getfirstClassSeatPrice());
            preparedStatement.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FlightDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * get all flights
     *
     * @return
     */
    public List<Flight> getAll() {
        List<Flight> flights = new ArrayList<Flight>();
        Connection conn = getConnection();
        try {
            String sql = "select * from Flight";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                flights.add(extractFlight(rs));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FlightDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flights;
    }

    public List<Flight> getFutureFlights() {
        List<Flight> flights = new ArrayList<Flight>();
        Connection conn = getConnection();
        try {
            String sql = "select * from Flight where departureDate > now()";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                flights.add(extractFlight(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flights;
    }

    public List<Flight> searchFlights(String fromCity, String toCity, String type, Date departureDate) {
        List<Flight> flights = new ArrayList<Flight>();
        for (Flight flight : getFutureFlights()) {
            if (fromCity != null && !fromCity.isEmpty() && !flight.getFromCity().equals(fromCity)) {
                continue;
            }

            if (toCity != null && !toCity.isEmpty() && !flight.getToCity().equals(toCity)) {
                continue;
            }

            if (type != null && !type.isEmpty() && type.equals("Economic") && flight.getSeats() <= 0) {
                continue;
            }

            if (type != null && !type.isEmpty() && type.equals("First class") && flight.getFirstClassSeats() <= 0) {
                continue;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            if (departureDate != null && !sdf.format(flight.getDepartureDate()).equals(sdf.format(departureDate))) {
                continue;
            }

            flights.add(flight);
        }
        return flights;
    }
}
