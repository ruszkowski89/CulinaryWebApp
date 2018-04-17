package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.Ingredient;
import ruszkowski89.springmvc.model.Unit;
import ruszkowski89.springmvc.service.IngredientService;

import java.util.Arrays;
import java.util.List;

@RequestMapping(value = {"/ingredients/", "/ingredients"})
@Transactional
@RestController
class IngredientController {
    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @ModelAttribute("allQuantities")
    public List<Unit> populateQuantities(){
        return Arrays.asList(Unit.ALL);
    }

    @ModelAttribute("ingredient")
    public Ingredient getNewIngredientObject(){
        return new Ingredient();
    }

    @GetMapping
    public ModelAndView showIngredients(){
        return new ModelAndView(
                                "Ingredients",
                                "ingredientsList",
                                ingredientService.getAll());
    }

    @GetMapping("/add")
    public ModelAndView showAddIngredient(){
        return new ModelAndView("AddIngredient");
    }

    @PostMapping(value = "/processAddIngredientForm")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView saveIngredient(@ModelAttribute("ingredient")Ingredient ingredient){
        if(!ingredientService.isInDatabase(ingredient)){
            ingredientService.save(ingredient);
        }
        return new ModelAndView("Ingredients");
    }

    @GetMapping(value = "/{id}")
    public ModelAndView showSingleIngredient(@PathVariable("id")Long id){
        return new ModelAndView(
                               "Ingredients",
                               "ingredient",
                               ingredientService.get(id));
    }

}
