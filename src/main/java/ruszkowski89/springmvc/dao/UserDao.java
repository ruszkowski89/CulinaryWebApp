package ruszkowski89.springmvc.dao;


import org.springframework.stereotype.Repository;
import ruszkowski89.springmvc.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    User getUserByUserName (String userName);
    void updateUser (User user);
    void deleteUser (User user);
    List<User> getAllUsers();

}
