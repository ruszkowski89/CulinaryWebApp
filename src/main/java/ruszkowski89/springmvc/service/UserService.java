package ruszkowski89.springmvc.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.User;

import java.security.Principal;
import java.util.List;

// extending UserDetailsService is needed for authentication purposes

public interface UserService extends UserDetailsService {
    List<User> getAll();
    User get(long id);
    User get(String userName);
    User getByEmail(String email);
    void deleteRecipeFromProfile(User user, Recipe recipe);
    boolean save(User user);
    void update(User user);
    void delete(long id);
    User getCurrentlyLoggedUser();
}
