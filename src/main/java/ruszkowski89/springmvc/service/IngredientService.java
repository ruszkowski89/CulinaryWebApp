package ruszkowski89.springmvc.service;

import ruszkowski89.springmvc.model.Ingredient;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.repository.IngredientRepository;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredients();
    Ingredient getIngredientById(long id);
    Ingredient getIngredientByName(String name);
    void addIngredient(Ingredient ingredient);
    void updateIngredient(Ingredient ingredient);
    void deleteIngredientFromRecipe(Recipe recipe, Ingredient ingredient);
    void deleteIngredientFromDatabase(long id);
}
