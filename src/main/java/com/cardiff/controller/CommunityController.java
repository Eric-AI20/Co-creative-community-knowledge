package com.cardiff.controller;

import com.cardiff.domain.UserDto;
import com.cardiff.entity.Community;
import com.cardiff.entity.User;
import com.cardiff.exception.UserAlreadyExistException;
import com.cardiff.service.CommunityService;
import com.cardiff.service.FragmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CommunityController {

    private CommunityService communityService;
    private FragmentService fragmentService;

    @Autowired
    public void setCommunityService(FragmentService fragmentService) {
        this.fragmentService = fragmentService;
    }

    @Autowired
    public void setCommunityService(CommunityService communityService) {
        this.communityService = communityService;
    }

//    @PostMapping("/home/registration")
//    public ModelAndView registerUserAccount(@ModelAttribute("community") @Valid UserDto userDto, HttpServletRequest request, Errors errors) {
//        ModelAndView mav = new ModelAndView("registration");
//        User registered = null;
//        try {
//            registered = community.registerNewUserAccount(userDto);
//            mav.addObject("message",
//                    "User registered successfully");
//
//        } catch (UserAlreadyExistException uaeEx) {
//            mav.addObject("message", "An account for that username/email already exists.");
//            return mav;
//        }
//        return new ModelAndView("successRegister", "user", userDto);
//
//    }
//}

    @GetMapping("/home/NewCommunity")
    public String ShowRegistrationForm(WebRequest request, Model model) {
        model.addAttribute("community", new Community());
        return "NewCommunity";
    }

    @GetMapping("/home")
    public String showRegistrationForm(WebRequest request, Model model) {
        //model.addAttribute("user", new UserDto());
        model.addAttribute("communityList", fragmentService.getAllCommunitiesForNavigation());
        return "home";
    }

    @GetMapping("/community/{id}")
    public String getCommunityById(WebRequest request, Model model, @PathVariable Long id) {
        //model.addAttribute("user", new UserDto());
        Community communityById = communityService.getCommunityById(id);

        if (communityById != null) {
            model.addAttribute("community", communityById);
        }
        model.addAttribute("communityList", fragmentService.getAllCommunitiesForNavigation());
        return "community";
    }
}
