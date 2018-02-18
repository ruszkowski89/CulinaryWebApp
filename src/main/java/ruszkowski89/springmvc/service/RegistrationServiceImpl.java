package ruszkowski89.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruszkowski89.springmvc.dao.UserDao;
import ruszkowski89.springmvc.model.User;

@Transactional
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserDao userDao;

    @Override
    public void registerUser(User user) {
        userDao.addUser(user);
    }
}
