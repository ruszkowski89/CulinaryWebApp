package ruszkowski89.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean verifyPassword(String userName, String password) {
        return (userRepository.findByUserName(userName).getPassword().equals(password));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<User>();
        for (User user: userRepository.findAll())
            list.add(user);

        return list;
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User getUserByUserName(String userName) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(long id) {

    }

}
