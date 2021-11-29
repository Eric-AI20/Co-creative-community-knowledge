package com.cardiff.controller;

import com.cardiff.entity.Location;
import com.cardiff.service.CommunityService;
import com.cardiff.service.FragmentService;
import com.cardiff.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;
import org.thymeleaf.standard.expression.Fragment;

import java.math.BigDecimal;
import java.util.Arrays;

@Controller
public class LocationController {


    private FragmentService fragmentService;
    private LocationService locationService;

    @Autowired
    public void setCommunityService(FragmentService fragmentService) {
        this.fragmentService = fragmentService;
    }

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public String showRegistrationForm(WebRequest request, Model model) {

        model.addAttribute("communityList", fragmentService.getAllCommunitiesForNavigation());
        //model.addAttribute("user", new UserDto());
        model.addAttribute("locations", locationService.findAllLocationsForMap());
        return "projectmap";
    }


}
