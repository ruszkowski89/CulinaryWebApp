package ruszkowski89.springmvc.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "INGREDIENT_DATA_ROW")
@Component
public class IngredientDataRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "UNIT_OF_WEIGHT")
    private UnitOfWeight unitOfWeight = UnitOfWeight.GRAM;

    @ManyToOne
    private Ingredient ingredient;

    @NotNull
    @Column(name = "AMOUNT")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "RECIPE")
    private Recipe recipe;

    public IngredientDataRow() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfWeight getUnitOfWeight() {
        return unitOfWeight;
    }

    public void setUnitOfWeight(UnitOfWeight unitOfWeight) {
        this.unitOfWeight = unitOfWeight;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return amount + " " + unitOfWeight + "(s) of " + ingredient;
    }
}
