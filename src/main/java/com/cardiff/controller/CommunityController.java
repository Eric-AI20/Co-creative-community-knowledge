package com.cardiff.controller;

import com.cardiff.entity.Community;
import com.cardiff.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.WebRequest;

@Controller
public class CommunityController {

    private CommunityService communityService;

    @Autowired
    public void setCommunityService(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping("/home")
    public String showRegistrationForm(WebRequest request, Model model) {
        //model.addAttribute("user", new UserDto());
        model.addAttribute("communityList", communityService.getAllCommunitiesForNavigation());
        return "home";
    }

    @GetMapping("/community/{id}")
    public String getCommunityById(WebRequest request, Model model, @PathVariable Long id) {
        //model.addAttribute("user", new UserDto());
        Community communityById = communityService.getCommunityById(id);

        if (communityById != null) {
            model.addAttribute("community", communityById);
        }
        model.addAttribute("communityList", communityService.getAllCommunitiesForNavigation());
        return "community";
    }
}
