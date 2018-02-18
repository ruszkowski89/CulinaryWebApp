package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.service.RegistrationService;

@Transactional
@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping(value = "/Register")
    public ModelAndView printNameFromForm(){
        return new ModelAndView("Register", "userModel", new User());
    }

    @PostMapping(value = "/Register")
    public String printNameFromForm(@ModelAttribute("userModel") User user){
        registrationService.registerUser(user);

        return "MembersArea";
    }
}
