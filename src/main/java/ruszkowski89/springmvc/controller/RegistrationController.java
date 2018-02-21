package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.service.IUserService;

@Transactional
@RestController
public class RegistrationController {

    @Autowired
    private IUserService IUserService;

    @GetMapping(value = "/Register")
    public ModelAndView printNameFromForm(){
        return new ModelAndView("Register", "user", new User());
    }

    @PostMapping(value = "/Register")
    public String printNameFromForm(@ModelAttribute("user") User user){


        return "redirect:/MembersArea";
    }
}
