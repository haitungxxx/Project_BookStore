/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130137.data.dtos;

/**
 *
 * @author haitu
 */
public class BookDTO {
    private String id;
    private String title;
    private int quantity;
    private double price;
    private String isActive;

    public BookDTO() {
    }

    public BookDTO(String id, String title, int quantity, double price, String isActive) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    
}
