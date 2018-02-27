package ruszkowski89.springmvc.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity(name = "RECIPE")
public class Recipe {

    @Column(name = "RECIPE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "RECIPE_NAME")
    private String name;

    @Column(name = "RECIPE_INGREDIENTS")
    @ManyToMany
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();

    @Column(name = "RECIPE_TIME")
    private int timeInMinutes;

    @Column(name = "RECIPE_DESCRIPTION")
    @Lob
    private String description;

    @Column(name = "RECIPE_PREPARATION_STEPS")
    @GenericGenerator(name = "increment-gen", strategy = "increment")
    @CollectionId(columns = {@Column(name = "PREPARATION_STEP_ID")},
            generator = "increment-gen", type = @Type(type = "long"))
    @ElementCollection
    private List<PreparationStep> preparationSteps = new ArrayList<PreparationStep>();

    @Column(name = "RECIPE_SUBMISSION_DATE")
    @Temporal(TemporalType.DATE)
    private Date submissionDate;

    @JoinColumn(name = "USER_ID")
    @ManyToOne
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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<PreparationStep> getPreparationSteps() {
        return preparationSteps;
    }

    public void setPreparationSteps(List<PreparationStep> preparationSteps) {
        this.preparationSteps = preparationSteps;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
