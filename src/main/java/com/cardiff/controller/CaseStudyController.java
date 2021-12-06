package com.cardiff.controller;

import com.cardiff.entity.CaseStudy;
import com.cardiff.service.CaseStudyService;
import com.cardiff.service.FragmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
    public String showRegistrationForm(WebRequest request, Model model,@PathVariable Long id) {

        //model.addAttribute("user", new UserDto());
        model.addAttribute("casestudy",caseStudyService.findById(id));
        model.addAttribute("communityList", fragmentService.getAllCommunitiesForNavigation());
        return "ViewCaseStudy";//Return to the HTML page
    }

    @GetMapping("/createCaseStudy")//URL
    public String showCaseStudyForm(WebRequest request, Model model) {
        model.addAttribute("casestudy", new CaseStudy());
        return "createCaseStudy";//Return to the HTML page
    }

    @PostMapping("/createCaseStudy")
    public ModelAndView saveCaseStudyForm(@ModelAttribute("caseStudy") CaseStudy caseStudy, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("createCaseStudy");
            CaseStudy savedCaseStudy = caseStudyService.saveCaseStudy(caseStudy);
            mav.addObject("message", "Case study add successfully");
            Long caseStudyId = savedCaseStudy.getId();
        return new ModelAndView("createCaseStudy", "caseStudy", savedCaseStudy);


    }

}
