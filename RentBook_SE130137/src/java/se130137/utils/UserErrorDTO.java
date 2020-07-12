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
public class UserErrorDTO {

    private String userIDError;
    private String fullNameError, passwordError, rePasswordError;

    public UserErrorDTO() {
    }

    public UserErrorDTO(String userIDError, String fullNameError, String passwordError, String rePasswordError) {
        this.userIDError = userIDError;
        this.fullNameError = fullNameError;
        this.passwordError = passwordError;
        this.rePasswordError = rePasswordError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getRePasswordError() {
        return rePasswordError;
    }

    public void setRePasswordError(String rePasswordError) {
        this.rePasswordError = rePasswordError;
    }

   

}
