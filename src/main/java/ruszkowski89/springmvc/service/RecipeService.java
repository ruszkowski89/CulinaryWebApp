package ruszkowski89.springmvc.service;

import ruszkowski89.springmvc.model.Ingredient;
import ruszkowski89.springmvc.model.PreparationStep;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.User;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(long id);
    List<Recipe> findRecipesByName(String name);
    void updateRecipe(Recipe recipe);
    void deleteRecipe(long id);
    void addRecipe(User user, Recipe recipe);
    void addIngredientToRecipe(Recipe recipe, Ingredient ingredient);

}
