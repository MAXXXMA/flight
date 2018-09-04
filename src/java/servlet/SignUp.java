/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {
    public boolean validateEmail(String emailStr) {
        Pattern VALID_EMAIL_ADDRESS_REGEX
                = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public boolean validatePassword(String password) {
        Pattern passwordPattern
                = Pattern.compile("[A-Za-z0-9]{6,}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.find();
    }
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
        request.getRequestDispatcher("WEB-INF/jsp/signup.jsp").forward(request, response);
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
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (!password.equals(password2)) {
            response.sendRedirect("SignUp?errorMsg=Two Password are not same");
            return;
        }

        if (!validatePassword(password)) {
            response.sendRedirect("SignUp?errorMsg=Password need to be at least 6 characters, contains only characters and numbers.");
            return;
        }

        if (!validateEmail(email)) {
            response.sendRedirect("SignUp?errorMsg=Email is not in a valid format");
            return;
        }

//        //        do sign up
//        BookSoapService_Service locator = new BookSoapService_Service();
//        BookSoapService bookSoapService = locator.getBookSoapServicePort();
//
//        try {
//            User user = bookSoapService.signup(email, password, name);
//            request.getSession().setAttribute("user", user);
//            response.sendRedirect("Index");
//        } catch (DuplicateEmailException_Exception ex) {
//            response.sendRedirect("SignUp?errorMsg=Existing email");
//            return;
//        } catch (DuplicateUsernameException_Exception ex) {
//            response.sendRedirect("SignUp?errorMsg=Existing username");
//            return;
//        }
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
