package ruszkowski89.springmvc.service;

import ruszkowski89.springmvc.model.User;

public interface LoginService {

    boolean verifyPassword(String userName, String password);

    void loginUser(User user);
}
