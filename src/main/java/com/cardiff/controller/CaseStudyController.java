package com.cardiff.controller;

import com.cardiff.service.CaseStudyService;
import com.cardiff.service.FragmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.WebRequest;

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

    @GetMapping("/caseStudy/{id}")
    public String showRegistrationForm(WebRequest request, Model model,@PathVariable Long id) {

        //model.addAttribute("user", new UserDto());
        model.addAttribute("casestudy",caseStudyService.findById(id));
        model.addAttribute("communityList", fragmentService.getAllCommunitiesForNavigation());
        return "ViewCaseStudy";
    }
}
