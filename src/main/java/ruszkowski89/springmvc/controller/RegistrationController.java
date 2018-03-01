package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.service.UserService;

@Transactional
@Controller
@SessionAttributes("user")
class RegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User getUserObject(){
        return new User();
    }

    @GetMapping(value = "/Register")
    public String printRegisterForm(){
        return "Register";
    }

    @PostMapping(value = "/Register")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@ModelAttribute("user") User user){
        if(userService.addUser(user))
            return "redirect:MembersArea";
        return "redirect:Register";
    }
}
