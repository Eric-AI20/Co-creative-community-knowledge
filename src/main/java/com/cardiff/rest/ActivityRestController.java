package com.cardiff.rest;

import com.cardiff.entity.Activity;
import com.cardiff.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
//@RequestMapping("/user")
public class ActivityRestController {
    @Autowired
    private ActivityService activityService;

    @PostMapping("/activity/add")
    public String addActivity(@RequestBody Activity activity) {
        activityService.add(activity);
        return "success";
    }

}
