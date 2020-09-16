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
import se130137.data.dtos.BookDTO;
import se130137.data.dtos.CartDTO;
import se130137.data.dtos.OrderDTO;
import se130137.utils.DBUtils;

/**
 *
 * @author haitu
 */
public class OrderDAO {

    public void insert(OrderDTO dto, CartDTO cart) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                //tblOrder
                String sql = "INSERT INTO tblOrder (orderID, userID, total, getDate, returnDate) "
                        + "Values(?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getOrderID());
                stm.setString(2, dto.getUserID());
                stm.setDouble(3, dto.getTotal());
                stm.setDate(4, dto.getGetDate());
                stm.setDate(5, dto.getReturnDate());
                stm.executeUpdate();

                //OrderDetail
                for (BookDTO book : cart.getCart().values()) {
                    String sql2 = "INSERT INTO OrderDetail (orderID, bookID, quantity) "
                            + "Values(?,?,?)";
                    stm = conn.prepareStatement(sql2);
                    stm.setString(1, dto.getOrderID());
                    stm.setString(2, book.getId());
                    stm.setInt(3, book.getQuantity());
                    stm.executeUpdate();

                    String sql3 = "UPDATE tblBook SET "
                            + "quantity = quantity - ? "
                            + "WHERE bookID=?"; //if search = "" -> show all list in database
                    stm = conn.prepareStatement(sql3);
                    stm.setInt(1, book.getQuantity());
                    stm.setString(2, book.getId());
                    stm.executeUpdate();
                }
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

    public BookDTO checkQuantityLeft(CartDTO cart) throws SQLException {
        BookDTO result = new BookDTO();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {

                for (BookDTO book : cart.getCart().values()) {
                    String sql = "SELECT quantity FROM tblBook "
                            + "WHERE bookID=?";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, book.getId());
                    rs = stm.executeQuery();
                    if (rs.next()) {
                        if (book.getQuantity() > rs.getInt("quantity")) {
                            result.setId(book.getId());
                            result.setQuantity(rs.getInt("quantity"));
                            break;
                        }
                    }
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

    public boolean checkID(String orderID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT total FROM tblOrder "
                        + "WHERE orderID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, orderID);
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

    public int getOrderLength() throws SQLException {
        int size = 1;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT COUNT(*) FROM tblOrder";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();

                rs.next();
                size = rs.getInt(1);
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
        return size;
    }
}
