package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.service.RegistrationServiceInterface;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationServiceInterface registrationService;

    @ModelAttribute("user")
    public User formBackingObject(){
        return new User();
    }

    @PostMapping(value = "/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@ModelAttribute("user") User user){
        registrationService.registerUser(user);
    }
}
