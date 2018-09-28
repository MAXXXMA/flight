/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.BaseDao;
import dao.BookingDao;
import dao.FlightDao;
import dto.Booking;
import dto.Flight;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.EmailService;

@WebServlet(name = "BookFlight", urlPatterns = {"/BookFlight"})
public class BookFlight extends HttpServlet {

    FlightDao flightDao = new FlightDao();
    BookingDao bookingDao = new BookingDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("Login");
            return;
        }

        String flightId = request.getParameter("flightId");
        String type = request.getParameter("type");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Flight flight = flightDao.getFlight(flightId);

        if (type.equals("First class")) {
            if (flight.getFirstClassSeats() < quantity) {
                response.sendRedirect("FlightDetail?flightId=" + flightId + "&errorMsg=Insuffient first class seats left");
                return;
            }
            if (flight.getSeats() < quantity) {
                response.sendRedirect("FlightDetail?flightId=" + flightId + "&errorMsg=Insuffient class seats left");
                return;
            }
        }

        Booking booking = bookingDao.createBooking(flightId, user.getUserId(), quantity, type);
        EmailService.sendMail(user.getEmail(), "You have booked successful", "Hey " + user.getName() + ",\n\nYou have just made an successful booking with booking number #" + booking.getBookingId() + ".\n\nManagement Team.");
        request.setAttribute("booking", booking);
        request.getRequestDispatcher("WEB-INF/jsp/bookFlight.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
