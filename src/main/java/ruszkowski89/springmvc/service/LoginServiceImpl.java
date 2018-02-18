package ruszkowski89.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruszkowski89.springmvc.dao.UserDao;
import ruszkowski89.springmvc.model.User;

@Transactional
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;


    @Override
    public boolean verifyPassword(String userName, String password) {
        User user = userDao.getUserByUserName(userName);
        return user.getPassword().equals(password);
    }

    @Override
    public void loginUser(User user) {

    }
}
