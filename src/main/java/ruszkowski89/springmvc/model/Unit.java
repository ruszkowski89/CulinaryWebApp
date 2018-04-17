package ruszkowski89.springmvc.model;

import javax.persistence.Embeddable;

@Embeddable
public enum Unit {
    GRAM("GRAM"),
    KILOGRAM("KILOGRAM"),
    MILILITER("MILILITER"),
    LITER("LITER"),
    TABLESPOON("TABLESPOON"),
    TEASPOON("TEASPOON"),
    UNIT("UNIT");

    public static final Unit[] ALL = {
        GRAM, KILOGRAM, MILILITER, LITER, TABLESPOON, TEASPOON, UNIT};

    String name;

    Unit(String quantity){
        this.name = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
