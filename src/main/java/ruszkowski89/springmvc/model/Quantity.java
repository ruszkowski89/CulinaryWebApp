package ruszkowski89.springmvc.model;

import org.springframework.stereotype.Component;

import javax.persistence.Embeddable;

@Embeddable
public enum Quantity {
    GRAM,
    KILOGRAM,
    MILILITER,
    LITER,
    TABLESPOON,
    TEASPOON,
    UNIT;

    private Quantity(){
    }
}
