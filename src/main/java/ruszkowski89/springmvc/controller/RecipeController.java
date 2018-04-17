package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.Ingredient;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.service.IngredientService;
import ruszkowski89.springmvc.service.RecipeService;
import ruszkowski89.springmvc.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

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
    public ModelAndView showRecipes(){
        return new ModelAndView("Recipes",
                                "recipeList",
                                recipeService.getAll());
    }

    @GetMapping(value = {"/{id}/", "/{id}"})
    public ModelAndView showSingleRecipe(@PathVariable("id")Long id){
        return new ModelAndView("Recipe",
                                "recipe",
                                recipeService.get(id));
    }

    @GetMapping(value = {"/addRecipe", "/addRecipe/"})
    public ModelAndView showAddRecipe(){
        return new ModelAndView("AddRecipe",
                                "ingredientList",
                                ingredientService.getAll());
    }

    @RequestMapping(value = "/addRecipe", params = {"addIngredient"})
    public ModelAndView addIngredient(Recipe recipe,
                                      BindingResult bindingResult){
        recipe.getIngredients().add(new Ingredient());
        return new ModelAndView("addRecipe");
    }

    @RequestMapping(value = "/addRecipe", params = {"removeIngredient"})
    public ModelAndView removeIngredient(Recipe recipe,
                                  BindingResult bindingResult,
                                  HttpServletRequest req){
        Integer ingredientId = Integer.valueOf(req.getParameter("removeIngredient"));
        recipe.getIngredients().remove(ingredientId.intValue());
        return new ModelAndView("addRecipe");
    }

    @PostMapping(value = {"/addRecipe", "/addRecipe/"}, params = {"save"})
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView saveRecipe(@ModelAttribute("recipe")Recipe recipe,
                                   BindingResult bindingResult){
        ModelAndView mav = new ModelAndView("Recipes");
        if(bindingResult.hasErrors()){
            return mav;
        }
        recipe.setUser(userService.getCurrentlyLoggedUser());
        recipe.setDate(Calendar.getInstance().getTime());
        recipeService.save(recipe);
        return mav;
    }

    @ModelAttribute("recipe")
    public Recipe getRecipeObject(){
        return new Recipe();
    }
}
