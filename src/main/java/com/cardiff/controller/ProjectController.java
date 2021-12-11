package com.cardiff.controller;

import com.cardiff.entity.Project;
import com.cardiff.service.FragmentService;
import com.cardiff.service.ProjectService;
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

    @GetMapping("/projects")
    public String viewProjectList(WebRequest request, Model model) {


        model.addAttribute("projects", projectService.findAllProjects());
        model.addAttribute("communityList", fragmentService.getAllCommunitiesForNavigation());
        return "projectslist";
    }

    @GetMapping("/createProject")
    public String createProject(WebRequest request, Model model) {

        model.addAttribute("project", new Project());
        model.addAttribute("communityList", fragmentService.getAllCommunitiesForNavigation());
        return "createProject";
    }

    @PostMapping("/newProject")
    public ModelAndView registerUserAccount(@ModelAttribute("project") @Valid Project project, HttpServletRequest request, Errors errors) {
        ModelAndView mav = new ModelAndView("redirect:/project/");
        Project savedProject = null;
        try {
            savedProject = projectService.createProject(project);

            mav.setViewName(mav.getViewName() + savedProject.getId());
            mav.addObject("message", "An account for that username/email already exists.");

        } catch (Exception ex) {
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
        }
        return mav;

    }

}
