package com.cardiff.controller;

import com.cardiff.entity.Community;
import com.cardiff.entity.Resource;
import com.cardiff.service.ResourceService;
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
public class ResourceController {

    private ResourceService resourceService;

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/resource/create/{id}")
    public String showCreateResourcePage(WebRequest request, Model model, @PathVariable Long id) {

        Resource resource = new Resource();
        Community community = new Community();
        community.setId(id);
        resource.setCommunity(community);
        model.addAttribute("resource", resource);
        return "createresource";
    }

    @PostMapping("/resource/create")
    public ModelAndView createResource(@ModelAttribute("resource") @Valid Resource resource, HttpServletRequest request, Errors errors) {
        ModelAndView mav = new ModelAndView("redirect:/community/" + resource.getCommunityId());
        Resource saved = null;
        try {

            Community community = new Community();
            community.setId(resource.getCommunityId());
            resource.setCommunity(community);
            saved = resourceService.createResource(resource);
            mav.addObject("message",
                    "Resource saved successfully");

        } catch (Exception ex) {
            mav.addObject("message", "Error occurred while saving Resource");
            return mav;
        }
        return mav;
    }


}
