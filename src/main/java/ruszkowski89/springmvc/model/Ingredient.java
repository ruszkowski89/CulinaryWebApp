package ruszkowski89.springmvc.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@Entity(name = "INGREDIENT")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INGREDIENT_ID")
    private long id;

    @NotNull
    @Column(name = "INGREDIENT_NAME")
    private String name;

    @Column(name = "INGREDIENT_QUANTITY")
    private Quantity quantity;

    @Lob
    @Column(name = "INGREDIENT_DESCRIPTION")
    private String description;

    @ManyToMany
    private List<Recipe> recipeList;

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public Ingredient() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
