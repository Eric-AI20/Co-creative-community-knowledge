package com.cardiff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ActivityController {

    @GetMapping ("/user/activity")
    public String activity() {
        return "activity";
    }

}
