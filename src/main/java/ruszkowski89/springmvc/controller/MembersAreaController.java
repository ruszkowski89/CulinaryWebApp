package ruszkowski89.springmvc.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@RestController
public class MembersAreaController {

    @GetMapping(value = "/MembersArea")
    public ModelAndView displayMembersArea(ModelAndView mav){
        mav.setViewName("MembersArea");

        return mav;
    }

}
