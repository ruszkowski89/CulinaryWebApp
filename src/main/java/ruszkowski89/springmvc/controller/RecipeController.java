package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.Ingredient;
import ruszkowski89.springmvc.model.IngredientDataRow;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.UnitOfWeight;
import ruszkowski89.springmvc.service.IngredientService;
import ruszkowski89.springmvc.service.RecipeService;
import ruszkowski89.springmvc.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

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
                                "allRecipes",
                                recipeService.getAll());
    }

    @GetMapping(value = {"/{id}/", "/{id}"})
    public ModelAndView showSingleRecipe(@PathVariable("id")Long id){
        return new ModelAndView("Recipe",
                                "recipeData",
                                recipeService.get(id));
    }

    @GetMapping(value = {"/addRecipe", "/addRecipe/"})
    public ModelAndView showAddRecipe(){
        return new ModelAndView("AddRecipe");
    }

    @RequestMapping(value = {"/addRecipe", "/addRecipe/"}, params = {"addRow"})
    public ModelAndView addIngredientDataRow(Recipe recipe,
                                      BindingResult bindingResult){
        IngredientDataRow row = new IngredientDataRow();
        row.setRecipe(recipe);
        recipe.getIngredientDataRows().add(row);
        return new ModelAndView("AddRecipe");
    }

    @RequestMapping(value = {"/addRecipe", "/addRecipe/"}, params = {"removeRow"})
    public ModelAndView removeIngredientDataRow(Recipe recipe,
                                  BindingResult bindingResult,
                                  HttpServletRequest req){
        Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        recipe.getIngredientDataRows().remove(rowId.intValue());
        return new ModelAndView("AddRecipe");
    }

    @PostMapping(value = {"/addRecipe", "/addRecipe/"})
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView saveRecipe(@ModelAttribute("recipe")Recipe recipe,
                                   BindingResult bindingResult){
        ModelAndView mav = new ModelAndView("Recipes");
        /*if(bindingResult.hasErrors()){
            return mav;
        }*/
        recipe.setUser(userService.getCurrentlyLoggedUser());
        recipe.setDate(Calendar.getInstance().getTime());
        recipeService.save(recipe);
        return mav;
    }

    @ModelAttribute("allIngredients")
    public List<Ingredient> getAllIngredients(){
        return ingredientService.getAll();
    }

    @ModelAttribute("recipe")
    public Recipe getRecipeObject(){
        return new Recipe();
    }

    @ModelAttribute("allUnitsOfWeight")
    public List<UnitOfWeight> getAllUnitsOfWeight(){
        return Arrays.asList(UnitOfWeight.ALL);
    }
}
