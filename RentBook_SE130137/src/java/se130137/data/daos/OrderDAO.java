/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130137.data.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
