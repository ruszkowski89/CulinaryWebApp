package ruszkowski89.springmvc.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.Role;
import ruszkowski89.springmvc.model.User;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAll();
    User get(long id);
    User get(String userName);
    void deleteRecipeFromProfile(User user, Recipe recipe);
    boolean save(User user);
    void delete(long id);
    User getCurrentlyLoggedUser();
}
