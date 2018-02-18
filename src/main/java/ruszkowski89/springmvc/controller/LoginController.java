package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.service.LoginService;

@Transactional
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView viewLoginPage(){
        ModelAndView mav = new ModelAndView("Login");
        mav.addObject("user", new User());
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String processLogin(@ModelAttribute("user") User user){

        if(!loginService.verifyPassword(user.getUserName(), user.getPassword())){
            System.out.println("User not found");
            return "Login";
        }

        return "MembersArea";
    }





}
