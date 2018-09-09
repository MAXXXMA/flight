package dao;

import dto.Flight;
import dto.Flights;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDao extends BaseDao {

    public Flight getFlight(String flightId) {
        for (Flight u : getAll().getFlights()) {
            if (u.getFlightId().equals(flightId)) {
                return u;
            }
        }
        return null;
    }

    /**
     * create new flight and store in xml
     *
     * @param flight
     */
    public void add(Flight flight) {
        Flights flights = getAll();
        flights.addFlight(flight);
        save(flights);
    }

    public void update(Flight flight) {
        int index = -1;
        List<Flight> flights = getAll().getFlights();
        for (int i = 0; i < flights.size(); i++) {
            Flight f = flights.get(i);
            if (f.getFlightId().equals(flight.getFlightId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            flights.set(index, flight);
            save(new Flights(flights));
        }
    }

    /**
     * get all flights
     *
     * @return
     */
    public Flights getAll() {
        return (Flights) this.get(Flights.class);
    }

    public List<Flight> getFutureFlights() {
        List<Flight> flights = new ArrayList<Flight>();
        for (Flight flight : getAll().getFlights()) {
            if (flight.getDepartureDate().compareTo(new Date()) >= 0) {
                flights.add(flight);
            }
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
