package com.cardiff.controller;

import com.cardiff.entity.Project;
import com.cardiff.service.FragmentService;
import com.cardiff.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.WebRequest;

@Controller
public class ProjectController {

    private ProjectService projectService;

    private FragmentService fragmentService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }


    @Autowired
    public void setFragmentService(FragmentService fragmentService) {
        this.fragmentService = fragmentService;
    }

    @GetMapping("/project/{id}")
    public String getCommunityById(WebRequest request, Model model, @PathVariable String id) {
        //model.addAttribute("user", new UserDto());
        Project projectById = projectService.getProjectById(Long.parseLong(id));

        if (projectById != null) {
            model.addAttribute("project", projectById);
        }
        model.addAttribute("communityList", fragmentService.getAllCommunitiesForNavigation());
        return "project";
    }

}
