/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130137.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author haitu
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    //error
    private static final String ERROR = "invalid.jsp";
    //account
    private static final String LOGIN = "LoginController";
    private static final String REGISTER = "RegisterController";
    private static final String LOGOUT = "LogoutController";

    //admin
    private static final String SEARCH = "Search_UserController";
    private static final String BAN = "UpdateStatus_UserController";
    private static final String UPDATE_PAGE = "update.jsp";
    private static final String UPDATE = "Update_UserController";

    private static final String SEARCH_BOOK_MNG = "Search_BookMngController";
    private static final String UPDATE_STATUS_BOOK = "UpdateStatus_BookController";
    private static final String UPDATE_BOOK_PAGE = "updateBook.jsp";
    private static final String UPDATE_BOOK = "Update_BookController";
    private static final String CREATE_BOOK_PAGE = "createBook.jsp";
    private static final String CREATE_BOOK = "CreateBookController";

    //user
    private static final String SEARCH_BOOK = "Search_BookController";
    private static final String ADD = "AddBook_CartController";
    private static final String VIEW = "view.jsp";
    private static final String REMOVE = "RemoveBook_CartController";
    private static final String UPDATE_QUANTITY = "UpdateQuantityBook_CartController";
    //checkOut
    private static final String CHECKOUT = "CheckOutController";

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

        String url = ERROR;
        try {
            String action = request.getParameter("btnAction");

            switch (action) {
                //account
                case "Login":
                    url = LOGIN;
                    break;
                case "Register":
                    url = REGISTER;
                    break;
                case "Logout":
                    url = LOGOUT;
                    break;

                //userMng
                case "Search":
                    url = SEARCH;
                    break;
                case "UpdatePage":
                    url = UPDATE_PAGE;
                    break;
                case "Update":
                    url = UPDATE;
                    break;
                case "Ban":
                    url = BAN;
                    break;
                //bookMng
                case "SearchBookMng":
                    url = SEARCH_BOOK_MNG;
                    break;
                //update
                case "UpdateStatusBook":
                    url = UPDATE_STATUS_BOOK;
                    break;
                case "UpdateBookPage":
                    url = UPDATE_BOOK_PAGE;
                    break;
                case "UpdateBook":
                    url = UPDATE_BOOK;
                    break;
                //create
                case "CreateBookPage":
                    url = CREATE_BOOK_PAGE;
                    break;
                case "CreateBook":
                    url = CREATE_BOOK;
                    break;

                //user
                case "SearchBook":
                    url = SEARCH_BOOK;
                    break;
                case "Add":
                    url = ADD;
                    break;
                case "View":
                    url = VIEW;
                    break;
                case "RemoveBook":
                    url = REMOVE;
                    break;
                case "UpdateQuantity":
                    url = UPDATE_QUANTITY;
                    break;
                //checkOut (user)
                case "CheckOut":
                    url = CHECKOUT;
                    break;
                default:
                    throw new Exception("Dont have this action: " + action);
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
