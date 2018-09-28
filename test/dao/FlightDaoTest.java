/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Flight;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlightDaoTest {

    private FlightDao flightDao;
    Flight newFlight;

    public FlightDaoTest() {
        flightDao = new FlightDao();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        newFlight = new Flight();
        newFlight.setFromCity("Sydney");
        newFlight.setToCity("Gold Coast");
        newFlight.setDepartureDate(new Date());
        newFlight.setArriveDate(new Date());
    }

    @After
    public void tearDown() {
        flightDao.remove(newFlight.getFlightId());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testAdd() {
        String flightId = newFlight.getFlightId();
        flightDao.add(newFlight);
        Flight fetchedFlight = flightDao.getFlight(flightId);
        assertTrue(fetchedFlight.getFromCity().equals(newFlight.getFromCity()));
        assertTrue(fetchedFlight.getToCity().equals(newFlight.getToCity()));
    }

    @Test
    public void testGet() {
        String flightId = newFlight.getFlightId();
        flightDao.add(newFlight);
        Flight fetchedFlight = flightDao.getFlight(flightId);
        assertTrue(fetchedFlight.getFromCity().equals(newFlight.getFromCity()));
        assertTrue(fetchedFlight.getToCity().equals(newFlight.getToCity()));

    }

    @Test
    public void testGetAll() {
        flightDao.add(newFlight);
        List<Flight> flights = flightDao.getAll();
        assertTrue(flights.size() > 0);
    }

    @Test
    public void testUpdate() {
        String flightId = newFlight.getFlightId();
        flightDao.add(newFlight);
        newFlight.setFromCity("Melbourne");
        flightDao.update(newFlight);
        Flight fetchedFlight = flightDao.getFlight(flightId);
        assertTrue(fetchedFlight.getFromCity().equals("Melbourne"));
        assertTrue(fetchedFlight.getToCity().equals(newFlight.getToCity()));
    }
    
    @Test
    public void testGetFuture() {
        flightDao.add(newFlight);
        List<Flight> flights = flightDao.getFutureFlights();
        Date now = new Date();
        for (Flight flight : flights) {
            assertTrue(flight.getDepartureDate().after(now));
        }
    }
    
    @Test
    public void testSearch() {
        flightDao.add(newFlight);
        List<Flight> flights = flightDao.searchFlights("Sydney", null, null, null);
        assertTrue(flights.size() > 0);
    }

    @Test
    public void testRemove() {
        String flightId = newFlight.getFlightId();
        flightDao.remove(flightId);
        Flight fetchedFlight = flightDao.getFlight(flightId);
        assertTrue(fetchedFlight == null);
    }

}
