/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130137.controllers.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se130137.data.dtos.UserDTO;
import se130137.data.daos.UserDAO;

/**
 *
 * @author haitu
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String SUCCESS_ADMIN = "admin.jsp";
    private static final String SUCCESS_USER = "Search_BookController";
    private static final String ERROR = "login.jsp";

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
            String userID = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");

            UserDAO dao = new UserDAO();
            UserDTO user_dto = dao.checkLogin(userID, password);

            HttpSession session = request.getSession();
            if (user_dto.getFullName() != null) {
                if (user_dto.isIsActive()) {
                    switch (user_dto.getRoleID()) {
                        case "admin":
                            url = SUCCESS_ADMIN;
                            break;
                        case "user":
                            url = SUCCESS_USER;
                            break;
                    }

                    session.setAttribute("LOGIN_USER", user_dto);
                } else {
                    session.setAttribute("userID", userID);
                    session.setAttribute("message", "This account have been banned.");
                }
            } else {
                session.setAttribute("userID", userID);
                session.setAttribute("message", "Login fail with UserID:" + userID + " and Password: ***");
            }
        } catch (Exception e) {
            log("Error ar LoginController: " + e.toString());
        } finally {
            response.sendRedirect(url);
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
