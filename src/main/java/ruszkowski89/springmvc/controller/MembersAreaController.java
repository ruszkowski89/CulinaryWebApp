package ruszkowski89.springmvc.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.service.RecipeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Transactional
@RestController
public class MembersAreaController {

    @Autowired
    private RecipeService recipeService;

    @ModelAttribute("recipe")
    public Recipe getRecipeObject(){
        return new Recipe();
    }

    @GetMapping(value = "/MembersArea")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView displayMembersArea(@SessionAttribute("user")User user){
        return initiateView(user,"MembersArea");
    }

    @GetMapping(value = "/Recipes")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView displayAllRecipes(@SessionAttribute("user")User user){
        ModelAndView mav = initiateView(user,"Recipes");
        return mav.addObject("recipeList", recipeService.getAllRecipes());
    }

    @GetMapping(value = "/Recipes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView displaySingleRecipe(@SessionAttribute("user")User user,
                                            @PathVariable("id")Long id){
        ModelAndView mav = initiateView(user, "Recipe");
        return mav.addObject("recipe", recipeService.getRecipeById(id));
    }

    @GetMapping(value = "/AddRecipe")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView displayAddRecipe(@SessionAttribute("user")User user){
        return initiateView(user,"AddRecipe");
    }

    @PostMapping(value = "/AddRecipe")
    @ResponseStatus(HttpStatus.CREATED)
    public String processAddRecipe(@SessionAttribute("user")User user,
                                   @ModelAttribute("recipe")Recipe recipe){
        recipeService.addRecipe(user, recipe);
        return "redirect:Recipes";
    }

    @GetMapping(value = "/Ingredients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView displayIngredients(@SessionAttribute("user")User user){
        return initiateView(user,"Ingredients");
    }

    @GetMapping(value = "/Users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView displayUsers(@SessionAttribute("user")User user){
        return initiateView(user,"Users");
    }

    // TODO
    @GetMapping(value = "/Profile")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView displayProfile(@SessionAttribute("user")User user){
        return initiateView(user,"Profile");
    }

    // to create ModelAndView object with USER object added to model from @SessionAttribute
    public ModelAndView initiateView(@SessionAttribute("user")User user, String viewName){
        ModelAndView mav = new ModelAndView();
        mav.setViewName(viewName);
        mav.addObject("user", user);
        return mav;
    }
}
