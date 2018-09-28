/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.BaseDao;
import dao.BookingDao;
import dao.FlightDao;
import dao.UserDao;
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

@WebServlet(name = "AdminAddBooking", urlPatterns = {"/AdminAddBooking"})
public class AdminAddBooking extends HttpServlet {

    BookingDao bookingDao = new BookingDao();
    FlightDao flightDao = new FlightDao();
    UserDao userDao = new UserDao();

   
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
        
        User user = (User) request.getSession().getAttribute("admin");
        if (user == null) {
            response.sendRedirect("Admin");
            return;
        }

        request.setAttribute("users", userDao.getAll());
        request.setAttribute("flights", flightDao.getAll());
        request.getRequestDispatcher("WEB-INF/jsp/admin/addBooking.jsp").forward(request, response);
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
        
        User user = (User) request.getSession().getAttribute("admin");
        if (user == null) {
            response.sendRedirect("Admin");
            return;
        }
        
        String flightId = request.getParameter("flightId");
        String userId = request.getParameter("userId");
        String type = request.getParameter("type");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Flight flight = flightDao.getFlight(flightId);

        if (type.equals("First class")) {
            if (flight.getFirstClassSeats() < quantity) {
                response.sendRedirect("AdminAddBooking?errorMsg=Insuffient first class seats left");
                return;
            }
            if (flight.getSeats() < quantity) {
                response.sendRedirect("AdminAddBooking?errorMsg=Insuffient class seats left");
                return;
            }
        }

        Booking booking = bookingDao.createBooking(flightId, userId, quantity, type);
        response.sendRedirect("AdminBookings");
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
