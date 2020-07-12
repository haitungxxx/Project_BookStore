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
public class BookErrorDTO {

    private String idError, titleError;
    private String priceError;
    private String quantityError;
    private String isActiveError;

    public BookErrorDTO() {
    }

    public BookErrorDTO(String idError, String titleError, String priceError, String quantityError, String isActiveError) {
        this.idError = idError;
        this.titleError = titleError;
        this.priceError = priceError;
        this.quantityError = quantityError;
        this.isActiveError = isActiveError;
    }

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getTitleError() {
        return titleError;
    }

    public void setTitleError(String titleError) {
        this.titleError = titleError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getIsActiveError() {
        return isActiveError;
    }

    public void setIsActiveError(String isActiveError) {
        this.isActiveError = isActiveError;
    }

    
}
