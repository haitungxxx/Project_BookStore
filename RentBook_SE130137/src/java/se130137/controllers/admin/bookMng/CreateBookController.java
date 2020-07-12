/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130137.controllers.admin.bookMng;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se130137.data.daos.BookDAO;
import se130137.data.dtos.BookDTO;
import se130137.utils.BookErrorDTO;

import se130137.utils.MyToys;


/**
 *
 * @author haitu
 */
@WebServlet(name = "CreateBookController", urlPatterns = {"/CreateBookController"})
public class CreateBookController extends HttpServlet {
    private static final String SUCCESS = "Search_BookMngController";
    private static final String ERROR = "createBook.jsp";
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
        response.setContentType("text/html;charset=UTF-8");

        MyToys toys = new MyToys();
        String url = ERROR;
        try {
            String bookID = request.getParameter("txtBookID");
            String title = request.getParameter("txtTitle");
            int quantity = toys.changeToInteger(request.getParameter("txtQuantity"));
            Double price = toys.changeToDouble(request.getParameter("txtPrice"));
            String isActive = "true";
            
            boolean check = true;

            BookErrorDTO errorDTO = new BookErrorDTO();
            if (bookID.isEmpty()) {
                errorDTO.setIdError("BookID is not empty");
                check = false;
            }
            if (title.isEmpty() || title.length() < 2 || title.length() > 8) {
                errorDTO.setTitleError("2 < Title < 8");
                check = false;
            }
            if (price < 0) {
                errorDTO.setPriceError("Price must be numbers and must > 0");
                check = false;
            }
            if (quantity < 0) {
                errorDTO.setQuantityError("Quantity must be an Integer and must > 0");
                check = false;
            }
            BookDAO dao = new BookDAO();

            if (dao.checkID(bookID)) {
                errorDTO.setIdError("Book ID already exist");
                check = false;
            }
            
            if (check) {
                BookDTO dto = new BookDTO(bookID, title, quantity, price, isActive);
                dao.insert(dto);
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR_BOOK", errorDTO);
            }
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
