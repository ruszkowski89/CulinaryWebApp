package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.service.IUserService;

@Transactional
@RestController
public class LoginController {

    @Autowired
    private IUserService IUserService;

    @GetMapping(value = "/")
    public ModelAndView viewLoginPage(){
        ModelAndView mav = new ModelAndView("Login");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping(value = "/processLogin")
    public ModelAndView processLogin(@ModelAttribute("user") User user){
        ModelAndView mav = new ModelAndView("Login");

        if(IUserService.verifyPassword(user.getUserName(), user.getPassword())){
            System.out.println("Password to account " + user.getUserName() + " accepted.");
            mav.setViewName("MembersArea");
            return mav;
        }

        return mav;
    }

}
