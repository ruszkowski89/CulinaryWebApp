package ruszkowski89.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeService recipeService;

    @Override
    public boolean verifyPassword(String userName, String password) {
        try {
            return (userRepository.findByUserName(userName).getPassword().equals(password));
        } catch (Exception e){
            return false;
        }
    }

    // checks if username or email aren't taken/null/empty && checks if password isn't null/empty
    @Override
    public boolean verifyUserDetailsBeforeRegistration(String userName, String email, String password) {
        if (userRepository.existsByUserName(userName) || StringUtils.isEmpty(userName) ||
            userRepository.existsByEmail(email) || StringUtils.isEmpty(userName) ||
            StringUtils.isEmpty(password))
            return false;

        return true;
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
        return userRepository.findById(id);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public boolean addUser(User user) {
        if (!verifyUserDetailsBeforeRegistration(user.getUserName(), user.getEmail(), user.getPassword()))
            return false;

        userRepository.save(user);
        return true;
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}
