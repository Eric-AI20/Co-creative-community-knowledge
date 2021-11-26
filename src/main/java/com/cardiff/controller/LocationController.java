package com.cardiff.controller;

import com.cardiff.entity.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import java.math.BigDecimal;
import java.util.Arrays;

@Controller
public class LocationController {

    @GetMapping("/locations")
    public String showRegistrationForm(WebRequest request, Model model) {
        //model.addAttribute("user", new UserDto());
        model.addAttribute("locations", Arrays.asList(new Location(BigDecimal.valueOf(51.621), BigDecimal.valueOf(-3.944)), new Location(BigDecimal.valueOf(51.482), BigDecimal.valueOf(-3.179))));
        return "projectmap";
    }


}
