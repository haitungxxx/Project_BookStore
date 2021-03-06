/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130137.controllers.user.rent;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se130137.data.dtos.BookDTO;
import se130137.data.dtos.CartDTO;

/**
 *
 * @author haitu
 */
@WebServlet(name = "AddBook_CartController", urlPatterns = {"/AddBook_CartController"})
public class AddBook_CartController extends HttpServlet {
    private static final String SUCCESS="Search_BookController";
    private static final String ERROR="invalid.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = ERROR;
        try {
            String id = request.getParameter("txtID");
            String title = request.getParameter("txtTitle");
            int quantity = 1;
            Double price = Double.parseDouble(request.getParameter("txtPrice"));
            boolean isActive = Boolean.parseBoolean(request.getParameter("txtIsActive"));
                    
            BookDTO book = new BookDTO(id, title, quantity, price, isActive);
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if(cart == null){
                cart = new CartDTO("", null);
            }
            cart.add(book);
            session.setAttribute("CART", cart);
            
            url = SUCCESS;
            request.setAttribute("message", "Add BookTitle:" + title + " Success!");    
        } catch (Exception e) {
            log("Error at AddBook_CartController:" + e.toString());
        } finally{
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
