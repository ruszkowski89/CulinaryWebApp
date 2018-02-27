package ruszkowski89.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import ruszkowski89.springmvc.model.Ingredient;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;

public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipeService recipeService;

    @Override
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();
        for (Ingredient ingredient: ingredientRepository.findAll())
            ingredientList.add(ingredient);

        return ingredientList;
    }

    @Override
    public Ingredient getIngredientById(long id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        return ingredientRepository.findByName(name);
    }

    @Override
    public void addIngredient(Recipe recipe, Ingredient ingredient) {
        recipeService.getRecipeById(recipe.getId()).getIngredients().add(ingredient);
    }

    @Override
    public void updateIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredientFromRecipe(Recipe recipe, Ingredient ingredient) {

        for (Ingredient ingredient1: recipe.getIngredients()){
            if (ingredient1.getName().equals(ingredient.getName()))
                recipe.getIngredients().remove(ingredient1);
        }
    }

    @Override
    public void deleteIngredientFromDatabase(long id) {
        ingredientRepository.deleteById(id);
    }

}
