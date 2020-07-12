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
import se130137.data.dtos.BookDTO;
import se130137.utils.DBUtils;

/**
 *
 * @author haitu
 */
public class BookDAO {

    public List<BookDTO> getListBook(String search) throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID, title, quantity, price, isActive "
                        + "FROM tblBook "
                        + "WHERE title like ?"; //if search = "" -> show all list in database
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String title = rs.getString("title");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    String isActive = rs.getString("isActive");
                    list.add(new BookDTO(bookID, title, quantity, price, isActive));
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
    
    public void updateStatus(String bookID) throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblBook SET "
                        + "isActive=?"
                        + " WHERE bookID=?"; //if search = "" -> show all list in database
                stm = conn.prepareStatement(sql);
                stm.setString(1, "false");
                stm.setString(2, bookID);
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

    public void update(BookDTO dto) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblBook SET "
                        + "title= ?, quantity=? ,price=? ,isActive=? "
                        + "WHERE bookID=?"; //if search = "" -> show all list in database
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getTitle());
                stm.setInt(2, dto.getQuantity());
                stm.setDouble(3, dto.getPrice());
                stm.setString(4, dto.getIsActive());
                stm.setString(5, dto.getId());
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

    public boolean checkID(String bookID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT title FROM tblBook WHERE "
                        + "bookID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, bookID);
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

    public void insert(BookDTO dto) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblBook (bookID, title, quantity, price, isActive) "
                        + "Values(?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getId());
                stm.setString(2, dto.getTitle());
                stm.setInt(3, dto.getQuantity());
                stm.setDouble(4, dto.getPrice());
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
