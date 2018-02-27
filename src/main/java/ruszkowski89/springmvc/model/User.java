package ruszkowski89.springmvc.model;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "USER")
public class User {

    @Column(name = "USER_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "USER_USERNAME")
    private String userName;

    @Column(name = "USER_PASSWORD")
    private String password;

    @Column(name = "USER_EMAIL")
    private String email;

    @Column(name = "USER_REGISTRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipesList = new ArrayList<Recipe>();

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Recipe> getRecipesList() {
        return recipesList;
    }

    public void setRecipesList(List<Recipe> recipesList) {
        this.recipesList = recipesList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString(){
        return "Customer[id=" + getId() +
               "username=" + getUserName() +
               "email=" + getEmail() + "]";
    }
}
