/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130137.data.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import se130137.data.dtos.UserDTO;
import se130137.utils.DBUtils;

/**
 *
 * @author haitu
 */
public class UserDAO {

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO result = new UserDTO();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT fullName, roleID, isActive FROM tblUser WHERE "
                        + "userID=? AND password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String isActive = rs.getString("isActive");

                    result.setFullName(fullName);
                    result.setRoleID(roleID);
                    result.setIsActive(isActive);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT userID, fullName, roleID, isActive"
                        + " FROM tblUser"
                        + " WHERE fullName like ?"; //if search = "" -> show all list in database
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String password = "***";
                    String roleID = rs.getString("roleID");
                    String isActive = rs.getString("isActive");
                    list.add(new UserDTO(userID, fullName, password, roleID, isActive));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public void ban(String userID) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblUser SET "
                        + "isActive=?"
                        + " WHERE userID=?"; //if search = "" -> show all list in database
                stm = conn.prepareStatement(sql);
                stm.setString(1, "false");
                stm.setString(2, userID);
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void update(UserDTO dto) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblUser SET "
                        + "fullName= ?, roleID=? "
                        + "WHERE userID=?"; //if search = "" -> show all list in database
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getFullName());
                stm.setString(2, dto.getRoleID());
                stm.setString(3, dto.getUserID());
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public boolean checkID(String userID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT fullName FROM tblUser WHERE "
                        + "userID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public void insert(UserDTO dto) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblUser (userID, password, fullName, roleID, isActive) "
                        + "Values(?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getUserID());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getFullName());
                stm.setString(4, dto.getRoleID());
                stm.setString(5, dto.getIsActive());
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
