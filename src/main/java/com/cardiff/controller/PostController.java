package com.cardiff.controller;

import com.cardiff.entity.*;
import com.cardiff.service.CommunityService;
import com.cardiff.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashSet;

@Controller
@RequestMapping("/forum")
public class PostController {

    private PostService postService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/home")
    public String showForumHome(Model model) {

        model.addAttribute("post", new Post());
        model.addAttribute("posts", postService.findAll());
        return "forum";
    }

    @PostMapping("/createPost")
    public ModelAndView createPost(@ModelAttribute("post") @Valid Post post, HttpServletRequest request, Errors errors) {


        ModelAndView mav = new ModelAndView("forum");
        User registered = null;
        try {
            String userName = request.getUserPrincipal().getName();

            postService.createPost(post, userName);
            mav.addObject("post", post);

        } catch (Exception ex) {
            mav.addObject("message", "Unable to create Post");

        }

        mav.addObject("posts", postService.findAll());
        return mav;

    }

}
