package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.service.IngredientService;
import ruszkowski89.springmvc.service.RecipeService;
import ruszkowski89.springmvc.service.UserService;

@RequestMapping(value = {"/recipes/", "/recipes"})
@Transactional
@RestController
class RecipeController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UserService userService;

    @Autowired
    public RecipeController(RecipeService recipeService,
                            IngredientService ingredientService,
                            UserService userService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView recipesPage(){
        return new ModelAndView("Recipes",
                                "recipeList",
                                recipeService.getAll());
    }

    @GetMapping(value = {"/{id}/", "/{id}"})
    public ModelAndView singleRecipePage(@PathVariable("id")Long id){
        return new ModelAndView("Recipe",
                                "recipe",
                                recipeService.get(id));
    }

    @GetMapping(value = {"/addRecipe", "/addRecipe/"})
    public ModelAndView addRecipePageWithIngredientListIncluded(){
        return new ModelAndView("AddRecipe",
                                "ingredientList",
                                ingredientService.getAll());
    }

    @PostMapping(value = {"/addRecipe", "/addRecipe/"})
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView processAddRecipeForm(@ModelAttribute("recipe")Recipe recipe){
        recipe.setUser(userService.getCurrentlyLoggedUser());
        recipeService.save(recipe);
        return new ModelAndView("Recipes");
    }

    @ModelAttribute("recipe")
    public Recipe getRecipeObject(){
        return new Recipe();
    }
}
