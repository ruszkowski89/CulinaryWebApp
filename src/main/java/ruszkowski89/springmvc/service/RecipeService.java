package ruszkowski89.springmvc.service;

import ruszkowski89.springmvc.model.Ingredient;
import ruszkowski89.springmvc.model.PreparationStep;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.User;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll();
    Recipe get(long id);
    void deleteIngredientFromRecipe(Ingredient ingredient, Recipe recipe);
    void save(Recipe recipe);
    void addIngredientToRecipe(Recipe recipe, Ingredient ingredient);
    User getAuthor(Recipe recipe);
    void delete(long id);
    List<Ingredient> getIngredients(Recipe recipe);

}
