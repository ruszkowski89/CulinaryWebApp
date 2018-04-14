package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.service.UserService;

import javax.validation.Valid;

@Transactional
@RestController
public class UserAccountController {

    private final UserService userService;

    @Autowired
    public UserAccountController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public User getUserObject(){
        return new User();
    }

    @GetMapping(value = {"/register/", "/register"})
    public ModelAndView viewRegisterPage(ModelAndView mav){
        mav.setViewName("Register");
        return mav;
    }

    @GetMapping(value = {"/login/", "/login"})
    public ModelAndView viewLoginPage(ModelAndView mav){
        mav.setViewName("Login");
        return mav;
    }

    @PostMapping(value = {"/processRegister/", "/processRegister"})
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView validateUserRegistrationForm(@ModelAttribute("user") @Valid User user,
                                                     BindingResult result,
                                                     ModelAndView mav){

        if (result.hasErrors()){
            mav.setViewName("Register");
        }
        else {
            userService.save(user);
            mav.setViewName("Login");
        }
        return mav;
    }

}
