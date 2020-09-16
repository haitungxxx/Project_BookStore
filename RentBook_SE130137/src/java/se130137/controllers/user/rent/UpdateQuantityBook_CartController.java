/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130137.controllers.user.rent;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se130137.data.dtos.BookDTO;
import se130137.data.dtos.CartDTO;
import se130137.utils.MyToys;

/**
 *
 * @author haitu
 */
@WebServlet(name = "UpdateQuantityBook_CartController", urlPatterns = {"/UpdateQuantityBook_CartController"})
public class UpdateQuantityBook_CartController extends HttpServlet {

    private static final String SUCCESS = "view.jsp";
    private static final String ERROR = "view.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        MyToys toys = new MyToys();
        String url = ERROR;
        try {
            String id = request.getParameter("txtID");
            int quantity = toys.changeToInteger(request.getParameter("txtQuantity"));
            if (quantity > 0) {
                HttpSession session = request.getSession();
                CartDTO cart = (CartDTO) session.getAttribute("CART");
                BookDTO newBook = null;

                //for de tranh sua~ gia
                for (BookDTO dto : cart.getCart().values()) {
                    if (dto.getId().equals(id)) {
                        newBook = new BookDTO(dto.getId(), dto.getTitle(), quantity, dto.getPrice(), dto.isIsActive());
                    }
                }

                cart.update(id, newBook);
                session.setAttribute("CART", cart);
                url = SUCCESS;
                
                request.setAttribute("message", "Update BookQuantity: " + quantity + " Success!");    
            }
        } catch (Exception e) {
            log("Error at UpdatePriceBook_CartController:" + e.toString());
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
