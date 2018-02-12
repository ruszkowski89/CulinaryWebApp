package ruszkowski89.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruszkowski89.springmvc.dao.UserDao;
import ruszkowski89.springmvc.model.User;

@Service
public class RegistrationService implements RegistrationServiceInterface{

    @Autowired
    private UserDao userDao;

    @Override
    public void registerUser(User user) {
        userDao.addUser(user);
    }
}
