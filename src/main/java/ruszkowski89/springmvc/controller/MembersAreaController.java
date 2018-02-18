package ruszkowski89.springmvc.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
public class MembersAreaController {

    @GetMapping(value = "/MembersArea")
    public String displayMembersArea(){
        return "MembersArea";
    }

}
