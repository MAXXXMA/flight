package dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "flights")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flights {

    @XmlElement(name = "flight")
    private List<Flight> flights;

    public Flights() {
        this.flights = new ArrayList<Flight>();
    }

    public Flights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public void addFlight(Flight p) {
        this.flights.add(p);
    }
    
    public int size() {
        return this.flights.size();
    }
}
