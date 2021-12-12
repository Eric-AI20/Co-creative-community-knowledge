package com.cardiff.controller;

import com.cardiff.entity.*;
import com.cardiff.service.FragmentService;
import com.cardiff.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/forum")
public class PostController {

    private PostService postService;
    private FragmentService fragmentService;

    @Autowired
    public void setFragmentService(FragmentService fragmentService) {
        this.fragmentService = fragmentService;
    }

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/home")
    public String showForumHome(Model model) {

        model.addAttribute("post", new Post());
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("comment", new Comment());
        model.addAttribute("communityList", fragmentService.getAllCommunitiesForNavigation());
        return "forum";
    }

    @PostMapping("/createPost")
    public ModelAndView createPost(@ModelAttribute("post") @Valid Post post, HttpServletRequest request, Errors errors) {

        ModelAndView mav = new ModelAndView("redirect:/forum/home");
        try {
            String userName = request.getUserPrincipal().getName();

            postService.createPost(post, userName);
            mav.addObject("post", new Post());

        } catch (Exception ex) {
            mav.addObject("post", new Post());
            mav.addObject("message", "Unable to create Post");
            System.err.println(ex.getMessage());
        }

        mav.addObject("posts", postService.findAll());
        return mav;

    }

    @PostMapping("/addComment/{id}")
    public ModelAndView addComment(@ModelAttribute("comment") @Valid Comment comment, @PathVariable Long id, HttpServletRequest request, Errors errors) {
        ModelAndView mav = new ModelAndView("redirect:/forum/home");
        try {
            String userName = request.getUserPrincipal().getName();

            Comment comment1 = postService.createComment(comment, userName, id);
            mav.addObject("post", new Post());

        } catch (Exception ex) {
            mav.addObject("post", new Post());
            mav.addObject("message", "Unable to add comment");
            System.err.println(ex.getMessage());
        }
        mav.addObject("posts", postService.findAll());
        return mav;

    }

}
