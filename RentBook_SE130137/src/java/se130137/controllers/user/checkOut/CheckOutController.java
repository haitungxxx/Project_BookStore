/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130137.controllers.user.checkOut;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se130137.data.daos.OrderDAO;
import se130137.data.dtos.BookDTO;
import se130137.data.dtos.CartDTO;
import se130137.data.dtos.OrderDTO;

/**
 *
 * @author haitu
 */
@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {

    private static final String SUCCESS = "Search_BookController";
    private static final String ERROR = "invalid.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;
        try {
            //CartDTO
            HttpSession session = request.getSession();
            CartDTO cart_dto = (CartDTO) session.getAttribute("CART");

            //OrderDTO
            //
            //orderID
            String orderID = "123";
            //userID
            String userID = "user";
            //total
            Double total = Double.parseDouble(request.getParameter("txtTotal"));
            
            //getDate
            Calendar cal = Calendar.getInstance();        
            Date date = new Date(cal.getTimeInMillis());
            //returnDate
            cal.add(Calendar.DATE, 14);
            Date returnDate = new Date(cal.getTimeInMillis());
            OrderDTO order_dto = new OrderDTO(orderID, userID, total, date, returnDate);
            
            
            OrderDAO dao = new OrderDAO();
            dao.insert(order_dto, cart_dto);
            session.removeAttribute("CART");
            url = SUCCESS;
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
