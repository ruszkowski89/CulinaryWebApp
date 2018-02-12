package ruszkowski89.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/index")
@RestController
public class IndexController {

    public String tempView(){
        return "temp";
    }
}
