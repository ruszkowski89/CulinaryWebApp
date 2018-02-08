package ruszkowski89.springmvc.model;

import org.springframework.stereotype.Component;

import java.util.List;

public class Recipe {

    private String name;
    private int timeNeededToPrepareInMinutes;
    private List<Ingredient> ingredientList;

}
