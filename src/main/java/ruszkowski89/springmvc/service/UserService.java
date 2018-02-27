package ruszkowski89.springmvc.service;

import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.User;

import java.util.List;

public interface UserService {

    boolean verifyPassword(String userName, String password);
    boolean verifyUserDetailsBeforeRegistration(String userName, String email, String password);
    List<User> getAllUsers();
    User getUserById(long id);
    User getUserByUserName(String userName);
    boolean addUser(User user);
    void updateUser(User user);
    void deleteUser(long id);

}
