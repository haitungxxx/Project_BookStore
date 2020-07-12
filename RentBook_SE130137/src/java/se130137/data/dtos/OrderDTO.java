/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130137.data.dtos;

import java.sql.Date;

/**
 *
 * @author haitu
 */
public class OrderDTO {
    private String orderID, userID;
    private double total;
    private Date getDate, returnDate;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String userID, double total, Date getDate, Date returnDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.total = total;
        this.getDate = getDate;
        this.returnDate = returnDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
    
}
