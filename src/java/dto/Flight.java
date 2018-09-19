package dto;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight {

    @XmlElement
    private String flightId;
    @XmlElement
    private String flightNumber;
    @XmlElement
    private String fromCity;
    @XmlElement
    private String toCity;
    @XmlElement
    private Date departureDate;
    @XmlElement
    private Date arriveDate;
    @XmlElement
    private int seats;
    @XmlElement
    private int firstClassSeats;
    @XmlElement
    private double seatPrice;
    @XmlElement
    private double firstClassSeatPrice;

    public Flight() {
        this.flightId = UUID.randomUUID().toString().substring(0, 8);
    }

    public Flight(String flightNumber, String fromCity, String toCity, Date departureDate, Date arriveDate, int seats, int firstClassSeats, double seatPrice, double firstClassSeatPrice) {

        this();
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.departureDate = departureDate;
        this.arriveDate = arriveDate;
        this.seats = seats;
        this.firstClassSeats = firstClassSeats;
        this.seatPrice = seatPrice;
        this.firstClassSeatPrice = firstClassSeatPrice;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getFirstClassSeats() {
        return firstClassSeats;
    }

    public void setFirstClassSeats(int firstClassSeats) {
        this.firstClassSeats = firstClassSeats;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }

    public double getfirstClassSeatPrice() {
        return firstClassSeatPrice;
    }

    public void setfirstClassSeatPrice(double firstClassSeatPrice) {
        this.firstClassSeatPrice = firstClassSeatPrice;
    }

    public String getDuration() {
        return getDurationBreakdown(this.arriveDate.getTime() - this.departureDate.getTime());
    }

       /**
     * Convert a millisecond duration to a string format
     * 
     * @param millis A duration to convert to a string form
     * @return A string of the form "X Days Y Hours Z Minutes A Seconds".
     */
    public static String getDurationBreakdown(long millis) {
        if(millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
        if (days > 0) {
            sb.append(days);
            sb.append(" d ");
        }
        if (hours > 0) {
            sb.append(hours);
            sb.append(" h ");
        }
        if (minutes > 0) {
            sb.append(minutes);
            sb.append(" m ");
        }
        if (seconds > 0) {
            sb.append(seconds);
            sb.append(" s");
        }

        return(sb.toString());
    }

}
