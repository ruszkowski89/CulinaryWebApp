package ruszkowski89.springmvc.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@Entity(name = "INGREDIENT")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INGREDIENT_ID")
    private long id;

    @NotBlank
    @Column(name = "INGREDIENT_NAME")
    private String name;

    @Lob
    @Column(name = "INGREDIENT_DESCRIPTION")
    private String description;

    @OneToMany
    private List<IngredientDataRow> ingredientDataRows;

    public List<IngredientDataRow> getIngredientDataRows() {
        return ingredientDataRows;
    }

    public void setIngredientDataRows(List<IngredientDataRow> ingredientDataRows) {
        this.ingredientDataRows = ingredientDataRows;
    }

    public Ingredient() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
