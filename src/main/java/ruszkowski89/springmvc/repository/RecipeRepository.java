package ruszkowski89.springmvc.repository;

import org.springframework.data.repository.CrudRepository;
import ruszkowski89.springmvc.model.Recipe;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findAllByName(String name);
    Recipe findById(long id);

}
