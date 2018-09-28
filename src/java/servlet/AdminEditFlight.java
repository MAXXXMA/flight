/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.BaseDao;
import dao.FlightDao;
import dto.Flight;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminEditFlight", urlPatterns = {"/AdminEditFlight"})
public class AdminEditFlight extends HttpServlet {

    FlightDao flightDao = new FlightDao();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User admin = (User) request.getSession().getAttribute("admin");
        
        if (admin == null) {
            response.sendRedirect("Admin");
            return;
        }

        String flightId = request.getParameter("flightId");
        Flight flight = new Flight();
        if (flightId != null) {
            flight = flightDao.getFlight(flightId);
        }

        request.setAttribute("flight", flight);
        request.getRequestDispatcher("WEB-INF/jsp/admin/editFlight.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String flightId = request.getParameter("flightId");
        try {
            String flightNumber = request.getParameter("flightNumber");
            String fromCity = request.getParameter("fromCity");
            String toCity = request.getParameter("toCity");
            String departureStr = request.getParameter("departure");
            String arriveStr = request.getParameter("arrive");
            int seats = Integer.parseInt(request.getParameter("seats"));
            int firstClassSeats = Integer.parseInt(request.getParameter("firstClassSeats"));
            double seatPrice = Double.parseDouble(request.getParameter("seatPrice"));
            double firstClassSeatPrice = Double.parseDouble(request.getParameter("firstClassSeatPrice"));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date departure = formatter.parse(departureStr);
            Date arrive = formatter.parse(arriveStr);

            Flight flight = new Flight();
            flight.setFromCity(fromCity);
            flight.setToCity(toCity);
            flight.setFlightNumber(flightNumber);
            flight.setArriveDate(arrive);
            flight.setDepartureDate(departure);
            flight.setSeats(seats);
            flight.setSeatPrice(seatPrice);
            flight.setFirstClassSeats(firstClassSeats);
            flight.setfirstClassSeatPrice(firstClassSeatPrice);
            
            if (flightId == null || flightId.isEmpty()) {
                flightDao.add(flight);
            } else {
                flight.setFlightId(flightId);
                flightDao.update(flight);
            }
            
            response.sendRedirect("AdminFlights");
        } catch (Exception e) {
            response.sendRedirect("AdminEditFlight?flightId=" + flightId + "&errorMsg=" + "Invalid params.");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
