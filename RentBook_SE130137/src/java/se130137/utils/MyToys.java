/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se130137.utils;

/**
 *
 * @author haitu
 */
public class MyToys {
    public int changeToInteger(String str){
        int n = -1;
        try {
           n = Integer.parseInt(str); 
           
        } catch (Exception e) {
        }
        return n;
    }
    
    public double changeToDouble(String str){
        double n = -1;
        try {
           n = Double.parseDouble(str); 
           
        } catch (Exception e) {
        }
        return n;
    }
}
