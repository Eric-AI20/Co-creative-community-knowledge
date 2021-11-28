package com.cardiff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fragments")
public class FragmentsController {
    @GetMapping("/sidebar")
    public String getHome() {
        return "navbar.html";
    }
}
