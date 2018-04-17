package ruszkowski89.springmvc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Component
@Entity(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private long id;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "USER_USERNAME", nullable = false, unique = true)
    private String userName;

    @NotNull
    @Size(min = 5)
    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @Email
    @NotNull
    @Column(name = "USER_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "REGISTRATION_DATE")
    private Date registrationDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
               name = "USERS_ROLES",
               joinColumns = @JoinColumn(
                   name = "USER_ID", referencedColumnName = "USER_ID"),
               inverseJoinColumns = @JoinColumn(
                   name = "ROLE_ID", referencedColumnName = "ROLE_ID"))
    private Collection<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipesList = new ArrayList<Recipe>();

    public User() {
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
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

    @Override
    public String toString(){
        return "User[id=" + getId() + ", " +
               "username=" + getUserName() + ", " +
               "email=" + getEmail() + ", " +
               "roles=" + getRoles() + "]";
    }
}
