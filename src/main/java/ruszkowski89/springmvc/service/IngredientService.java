package ruszkowski89.springmvc.service;

import ruszkowski89.springmvc.model.Ingredient;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.repository.IngredientRepository;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAll();
    Ingredient get(long id);
    Ingredient get(String name);
    void save(Ingredient ingredient);
    void update(Ingredient ingredient);
    void deleteFromDatabase(long id);
    boolean isInDatabase(Ingredient ingredient);

}
