package ruszkowski89.springmvc.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruszkowski89.springmvc.model.Ingredient;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.repository.RecipeRepository;
import ruszkowski89.springmvc.repository.UserRepository;

import java.util.List;
import java.util.Set;

@Transactional
@Service("RecipeService")
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    private final UserService userService;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, UserService userService) {
        this.recipeRepository = recipeRepository;
        this.userService = userService;
    }

    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getAll() {
        return Lists.newArrayList(recipeRepository.findAll());
    }

    @Override
    public Recipe get(long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        recipeRepository.deleteById(id);
    }

    public List<Ingredient> getIngredients(Recipe recipe){
        return recipe.getIngredients();
    }

    // TODO: find a clean way to write addIngredient and deleteIngredient methods
    @Override
    public void addIngredientToRecipe(Recipe recipe, Ingredient ingredient) {
        List<Ingredient> ingredientList = getIngredients(recipe);
        ingredientList.add(ingredient);
        recipe.setIngredients(ingredientList);
        recipeRepository.save(recipe);
    }

    @Override
    public void deleteIngredientFromRecipe(Ingredient ingredient, Recipe recipe) {
        List<Ingredient> ingredientList = getIngredients(recipe);
        ingredientList.remove(ingredient);
        recipe.setIngredients(ingredientList);
        recipeRepository.save(recipe);
    }

    @Override
    public User getAuthor(Recipe recipe) {
        return recipe.getUser();
    }
}
