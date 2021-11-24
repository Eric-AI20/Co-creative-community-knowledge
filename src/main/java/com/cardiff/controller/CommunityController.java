package com.cardiff.controller;

import com.cardiff.entity.Community;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;

@Controller
public class CommunityController {
    @GetMapping("/home")
    public String showRegistrationForm(WebRequest request, Model model) {
        //model.addAttribute("user", new UserDto());
        model.addAttribute("communityList", Arrays.asList(new Community(1L, "Community 1"), new Community(2L, "Community 2")));
        return "home";
    }

    @GetMapping("/community/{id}")
    public String getCommunityById(WebRequest request, Model model, @PathVariable String id) {
        //model.addAttribute("user", new UserDto());

        model.addAttribute("community", new Community(1L, "Community 1"));
        model.addAttribute("communityList", Arrays.asList(new Community(1L, "Community 1"), new Community(2L, "Community 2")));
        return "community";
    }
}
