package dao;

import dto.Flight;
import dto.Flights;

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
    public void addFlight(Flight flight) {
        Flights flights = getAll();
        flights.addFlight(flight);
        save(flights);
    }

    /**
     * get all flights
     *
     * @return
     */
    public Flights getAll() {
        return (Flights) this.get(Flights.class);
    }
}
