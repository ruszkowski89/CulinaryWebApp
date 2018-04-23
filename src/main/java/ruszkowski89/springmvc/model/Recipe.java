package ruszkowski89.springmvc.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

@Component
@Entity(name = "RECIPE")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @NotBlank
    @Column(name = "NAME")
    private String name;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "INGREDIENT_DATA_ROW")
    private List<IngredientDataRow> ingredientDataRows = new ArrayList<>();

    @NotNull
    @Column(name = "TIME")
    private int timeInMinutes;

    @NotBlank
    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE")
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public List<IngredientDataRow> getIngredientDataRows() {
        return ingredientDataRows;
    }

    public void setIngredients(List<IngredientDataRow> ingredientDataRows) {
        this.ingredientDataRows = ingredientDataRows;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
