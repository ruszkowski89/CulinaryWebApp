package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.service.UserService;

@SessionAttributes("user")
@Transactional
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User setUpUserForm(){
        return new User();
    }

    @GetMapping(value = "/")
    public String viewLoginPage(){
        return "Login";
    }

    @PostMapping(value = "/processLogin")
    public String processLogin(@ModelAttribute("user") User user, Model model){

        if(userService.verifyPassword(user.getUserName(), user.getPassword())){
            user = userService.getUserById(user.getId());
            return "redirect:MembersArea";
        } else {
            model.addAttribute("message", "Login failed. Username or password is propably incorrect.");
        }

        return "Login";
    }

}
