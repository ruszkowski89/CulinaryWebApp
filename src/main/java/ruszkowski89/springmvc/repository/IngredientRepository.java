package ruszkowski89.springmvc.repository;

import org.springframework.data.repository.CrudRepository;
import ruszkowski89.springmvc.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
    Ingredient findById(long id);
    Ingredient findByName(String name);
    boolean existsByName(String name);
}
