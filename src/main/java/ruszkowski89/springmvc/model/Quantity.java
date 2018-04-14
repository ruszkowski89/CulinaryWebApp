package ruszkowski89.springmvc.model;

import org.springframework.stereotype.Component;

import javax.persistence.Embeddable;

@Embeddable
public enum Quantity {
    GRAM("GRAM"),
    KILOGRAM("KILOGRAM"),
    MILILITER("MILILITER"),
    LITER("LITER"),
    TABLESPOON("TABLESPOON"),
    TEASPOON("TEASPOON"),
    UNIT("UNIT");

    String quantity;

    Quantity(String quantity){
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
