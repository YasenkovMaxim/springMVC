package com.maxim.controller;

import com.maxim.model.dto.RequestRegistrationDTO;
import com.maxim.model.dto.UserResponse;
import com.maxim.service.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/security")

public class SecurityController {
    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute RequestRegistrationDTO registrationDTO,
                                     ModelAndView modelAndView) {
        UserResponse userResponse = securityService.registration(registrationDTO);
        modelAndView.addObject("first_name", userResponse.getFirstName());
        modelAndView.addObject("last_name", userResponse.getLastName());
        modelAndView.addObject("age", userResponse.getAge());
        modelAndView.addObject("email", userResponse.getEmail());
        modelAndView.setViewName("registration-response");
        return modelAndView;
    }
}
