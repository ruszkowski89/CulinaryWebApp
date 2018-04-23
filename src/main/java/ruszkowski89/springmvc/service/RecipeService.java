package ruszkowski89.springmvc.service;

import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.User;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll();
    Recipe get(long id);
    void save(Recipe recipe);
    User getAuthor(Recipe recipe);
    void delete(long id);

}
