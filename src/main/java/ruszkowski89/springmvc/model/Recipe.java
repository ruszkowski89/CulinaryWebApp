package ruszkowski89.springmvc.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

@Component
@Entity(name = "RECIPE")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RECIPE_ID")
    private long id;

    @Column(name = "RECIPE_NAME")
    private String name;

    @ManyToMany
    @Column(name = "RECIPE_INGREDIENTS")
    private List<Ingredient> ingredients = new ArrayList<>();

    @Column(name = "RECIPE_TIME")
    private int timeInMinutes;

    @Lob
    @Column(name = "RECIPE_DESCRIPTION")
    private String description;

    @GenericGenerator(name = "increment-gen", strategy = "increment")
    @CollectionId(columns = {@Column(name = "PREPARATION_STEP_ID")},
                  generator = "increment-gen", type = @Type(type = "long"))
    @ElementCollection
    @Column(name = "RECIPE_PREPARATION_STEPS")
    private List<PreparationStep> preparationSteps = new ArrayList<PreparationStep>();

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<PreparationStep> getPreparationSteps() {
        return preparationSteps;
    }

    public void setPreparationSteps(List<PreparationStep> preparationSteps) {
        this.preparationSteps = preparationSteps;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
