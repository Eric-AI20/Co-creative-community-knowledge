package com.cardiff.controller;

import com.cardiff.entity.Activity;
import com.cardiff.entity.CaseStudy;
import com.cardiff.entity.Community;
import com.cardiff.entity.Project;
import com.cardiff.exception.UserAlreadyExistException;
import com.cardiff.service.CaseStudyService;
import com.cardiff.service.CommunityService;
import com.cardiff.service.FragmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashSet;

@Controller
public class CaseStudyController {

    private FragmentService fragmentService;
    private CaseStudyService caseStudyService;


    @Autowired
    public void setFragmentService(FragmentService fragmentService) {
        this.fragmentService = fragmentService;
    }

    @Autowired
    public void setCaseStudyService(CaseStudyService caseStudyService) {
        this.caseStudyService = caseStudyService;
    }

    @GetMapping("/viewCaseStudy/{id}")//URL
    public String showRegistrationForm(WebRequest request, Model model, @PathVariable Long id) {

        //model.addAttribute("user", new UserDto());
        model.addAttribute("casestudy", caseStudyService.findById(id));
        model.addAttribute("communityList", fragmentService.getAllCommunitiesForNavigation());
        return "ViewCaseStudy";//Return to the HTML page
    }

    @GetMapping("/createCaseStudy/{id}")//URL
    public String showCaseStudyForm(WebRequest request, Model model, @PathVariable Long id) {
        CaseStudy caseStudy = new CaseStudy();
        Community community = new Community();
        community.setId(id);
        caseStudy.setCommunity(community);

        model.addAttribute("casestudy", caseStudy);
        return "createCaseStudy";//Return to the HTML page
    }

    @PostMapping("/createCaseStudy")
    public ModelAndView saveCaseStudyForm(@ModelAttribute("caseStudy") CaseStudy caseStudy, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("redirect:/viewCaseStudy/");

        try {
            Community community = new Community();
            community.setId(caseStudy.getCommunityId());
            caseStudy.setCommunity(community);
            CaseStudy savedCaseStudy = caseStudyService.saveCaseStudy(caseStudy);
            mav.addObject("message",
                    "CaseStudy create successfully");
            Long caseStudyId = savedCaseStudy.getId();
            mav.setViewName(mav.getViewName() + caseStudyId);
        } catch (ExpressionException e) {
            mav.addObject("message", "error");
            return mav;
        }

        return mav;


    }

}
