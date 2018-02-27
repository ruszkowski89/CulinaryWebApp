package ruszkowski89.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruszkowski89.springmvc.model.Ingredient;
import ruszkowski89.springmvc.model.PreparationStep;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("RecipeService")
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipeList = new ArrayList<Recipe>();
        for (Recipe recipe: recipeRepository.findAll())
            recipeList.add(recipe);

        return recipeList;
    }

    @Override
    public Recipe getRecipeById(long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public List<Recipe> findRecipesByName(String name) {
        List<Recipe> recipeList = new ArrayList<Recipe>();
        for(Recipe recipe: recipeRepository.findAllByName(name))
            recipeList.add(recipe);

        return recipeList;
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(long id) {
        // to delete recipe from user object
        User user = recipeRepository.findById(id).getUser();
        for (Recipe recipe: user.getRecipesList()) {
            if (recipe.getId() == id)
                user.getRecipesList().remove(recipe);
        }
        userService.updateUser(user);

        // to delete recipe from recipe database
        recipeRepository.deleteById(id);
    }

    // TODO: refactory adding RecipeOwner(user), maybe through session object ?
    @Override
    public void addRecipe(User user, Recipe recipe) {
        recipeRepository.save(recipe);
        userService.getUserById(user.getId()).getRecipesList().add(recipe);
    }


}
