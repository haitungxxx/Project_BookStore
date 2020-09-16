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
import se130137.data.dtos.UserDTO;
import se130137.data.daos.UserDAO;
import se130137.utils.UserErrorDTO;


/**
 *
 * @author haitu
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {
    private static final String SUCCESS = "login.jsp";
    private static final String ERROR = "register.jsp";
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
            String fullName = request.getParameter("txtFullName");
            String roleID = "2";
            String password = request.getParameter("txtPassword");
            String rePassword = request.getParameter("txtRePassword");
            boolean isActive = true;
            boolean check = true;

            UserErrorDTO errorDTO = new UserErrorDTO();
            if (userID.isEmpty()) {
                errorDTO.setUserIDError("UserID is not empty");
                check = false;
            }
            if (fullName.isEmpty() || fullName.length() < 2 || fullName.length() > 16) {
                errorDTO.setFullNameError("2 < FullName < 16");
                check = false;
            }
            if (!password.equals(rePassword)) {
                errorDTO.setRePasswordError("rePassword must like password");
                check = false;
            }
            UserDAO dao = new UserDAO();

            if (dao.checkID(userID)) {
                errorDTO.setUserIDError("User ID already exist");
                check = false;
            }
            
            if (check) {
                UserDTO dto = new UserDTO(userID, fullName, password, roleID, isActive);
                dao.insert(dto);
                url = SUCCESS;
                
                request.setAttribute("message", "Register Success!");
            } else {
                request.setAttribute("ERROR", errorDTO);
            }
        } catch (Exception e) {
            log("Error ar RegisterController: " + e.toString());
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
