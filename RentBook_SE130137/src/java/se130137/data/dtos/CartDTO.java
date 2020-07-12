/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130137.data.dtos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author haitu
 */
public class CartDTO {
    private String customerName;
    private Map<String, BookDTO> cart;

    public CartDTO() {
    }

    public CartDTO(String customerName, Map<String, BookDTO> cart) {
        this.customerName = customerName;
        this.cart = cart;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the cart
     */
    public Map<String, BookDTO> getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(Map<String, BookDTO> cart) {
        this.cart = cart;
    }
    
    public void add(BookDTO dto) {
        if (this.cart == null) {
            cart = new HashMap<>();
        }

        if (this.cart.containsKey(dto.getId())) {
            int quantity = cart.get(dto.getId()).getQuantity();
            dto.setQuantity(quantity + 1);
        }

        cart.put(dto.getId(), dto);
    }

    
    public void delete(String id){
        if(this.cart == null){
            return;
        }
        
        if(this.cart.containsKey(id)){
            this.cart.remove(id);
        }
    }
    
    public void update(String id, BookDTO dto){
        if(cart != null){
            if(cart.containsKey(id)){
                this.cart.replace(id, dto);
            }
        }
    }
}
