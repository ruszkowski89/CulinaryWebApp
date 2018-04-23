package ruszkowski89.springmvc.model;

public enum UnitOfWeight {
    GRAM("GRAM"),
    KILOGRAM("KILOGRAM"),
    MILILITER("MILILITER"),
    LITER("LITER"),
    TABLESPOON("TABLESPOON"),
    TEASPOON("TEASPOON"),
    UNIT("UNIT");

    public static final UnitOfWeight[] ALL = {
        GRAM, KILOGRAM, MILILITER, LITER, TABLESPOON, TEASPOON, UNIT};

    private final String name;

    private UnitOfWeight(final String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

}
