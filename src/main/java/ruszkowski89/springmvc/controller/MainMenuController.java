package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.Ingredient;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.service.IngredientService;
import ruszkowski89.springmvc.service.RecipeService;

import javax.persistence.criteria.CriteriaBuilder;

@Transactional
@RestController
class MainMenuController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private IngredientService ingredientService;



    // -----------------------------------------//
    //                   GET                    //
    // -----------------------------------------//



    @GetMapping(value = "/Users")
    public ModelAndView displayAllUsers(@SessionAttribute("user")User user){
        return initiateView(user,"Users")
                            .addObject("userList", recipeService.getAllRecipes());
    }



    @GetMapping(value = "/Users/{id}")
    public ModelAndView displaySingleUser(@SessionAttribute("user")User user,
                                          @PathVariable("id") Long id){
        return initiateView(user,"User")
                            .addObject("user", recipeService.getRecipeById(id));
    }



    @GetMapping(value = "/Profile")
    public ModelAndView displayProfile(@SessionAttribute("user")User user){
        return initiateView(user,"Profile");
    }



    @GetMapping(value = "/MainMenu")
    public ModelAndView displayMainMenu(@SessionAttribute("user")User user){
        return initiateView(user,"MainMenu");
    }



    @GetMapping(value = "/Recipes")
    public ModelAndView displayAllRecipes(@SessionAttribute("user")User user,
                                          @PathVariable("id")Long id){

        return initiateView(user,"Recipes")
                            .addObject("recipeList", recipeService.getAllRecipes());
    }



    @GetMapping(value = "/Recipes/{id}")
    public ModelAndView displaySingleRecipe(@SessionAttribute("user")User user,
                                            @PathVariable("id")Long id){
        ModelAndView mav = initiateView(user, "Recipe");
        return mav.addObject("recipe", recipeService.getRecipeById(id));
    }



    @GetMapping(value = "/Ingredients")
    public ModelAndView displayAllIngredients(@SessionAttribute("user")User user){
        return initiateView(user,"Ingredients");
    }



    @GetMapping(value = "/Ingredients/{id}")
    public ModelAndView displaySingleIngredient(@SessionAttribute("user")User user,
                                                @PathVariable("id")Long id){
          return initiateView(user,"Ingredient")
                              .addObject("ingredient", ingredientService.getIngredientById(id));
    }



    @GetMapping(value = "/AddRecipe")
    public ModelAndView displayAddRecipe(@SessionAttribute("user")User user){
        return initiateView(user,"AddRecipe")
                            .addObject("ingredientList", ingredientService.getAllIngredients());
    }



    // -----------------------------------------//
    //                  POST                    //
    // -----------------------------------------//



    @PostMapping(value = "/AddIngredientToDatabase")
    @ResponseStatus(HttpStatus.CREATED)
    public String processAddIngredient(@SessionAttribute("user")User user,
                                       @ModelAttribute("ingredient")Ingredient ingredient){
        ingredientService.addIngredient(ingredient);
        return "redirect:Ingredients";
    }



    @PostMapping(value = "/AddRecipe")
    @ResponseStatus(HttpStatus.CREATED)
    public String processAddRecipe(@SessionAttribute("user")User user,
                                   @ModelAttribute("recipe")Recipe recipe){
        recipeService.addRecipe(user, recipe);
        return "redirect:Recipes";
    }



    @PostMapping(value = "/AddIngredientToRecipe")
    @ResponseStatus(HttpStatus.CREATED)
    public String addIngredientToRecipe(@SessionAttribute("user")User user,
                                        @ModelAttribute("ingredient")Ingredient ingredient){
        ModelAndView mav = initiateView(user, "AddRecipe"),
    }



    // -----------------------------------------//
    //                 MODEL ATTRIBUTE          //
    // -----------------------------------------//



    @ModelAttribute("recipe")
    public Recipe getRecipeObject(){
        return new Recipe();
    }



    @ModelAttribute("ingredient")
    public Ingredient getIngredientObject(){
        return new Ingredient();
    }



    // -----------------------------------------//
    //              INITIATE VIEW               //
    // -----------------------------------------//



    // to create ModelAndView object with USER object added to model from @SessionAttribute
    public ModelAndView initiateView(@SessionAttribute("user")User user, String viewName){
        ModelAndView mav = new ModelAndView();
        mav.setViewName(viewName);
        mav.addObject("user", user);
        return mav;
    }



    // -----------------------------------------//
    //               EXCEPTIONS                 //
    // -----------------------------------------//



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public class BadRequestException extends RuntimeException {
        //
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        //
    }
}
