package ruszkowski89.springmvc.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruszkowski89.springmvc.model.Ingredient;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.repository.IngredientRepository;

import java.util.List;
import java.util.Set;

@Service("ingredientService")
@Transactional
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getAll() {
        return Lists.newArrayList(ingredientRepository.findAll());
    }

    @Override
    public Ingredient get(long id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public Ingredient get(String name) {
        return ingredientRepository.findByName(name);
    }

    @Override
    public void delete(long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public boolean isInDatabase(Ingredient ingredient) {
        return ingredientRepository.existsByName(ingredient.getName());
    }

}
