package ruszkowski89.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ruszkowski89.springmvc.service.UserService;

@Transactional
@RestController
class MainMenuController {
    private final UserService userService;

    @Autowired
    public MainMenuController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/"})
    public ModelAndView showHome(){
        return new ModelAndView("Home");
    }

    @GetMapping(value = {"/users/", "/users"})
    public ModelAndView showUsers(){
        return new ModelAndView(
                                "Users",
                                "userList",
                                userService.getAll());
    }

    @GetMapping(value = {"/users/{id}/", "/users/{id}"})
    public ModelAndView showSingleUser(@PathVariable("id") Long id){
        return new ModelAndView(
                                "User",
                                "userToDisplay",
                                userService.get(id));
    }

    @GetMapping(value = {"/profile/", "/profile"})
    public ModelAndView showLoggedUser(){
        return new ModelAndView(
                                "Profile",
                                "user",
                                 userService.getCurrentlyLoggedUser());
    }

    // TODO
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public class BadRequestException extends RuntimeException {

    }

    // TODO
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {

    }
}
