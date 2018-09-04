package dao;

import dto.Flight;
import dto.Flights;
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

    public void update(Flight flight){
        int index = -1;
        List<Flight> flights = getAll().getFlights();
        for(int i = 0; i < flights.size(); i++) {
            Flight f = flights.get(i);
            if (f.getFlightId().equals(flight.getFlightId())) {
                index = i;
                break;
            }
        }
        if (index != -1){
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
}
