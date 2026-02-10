package com.maxim.controller;

import com.maxim.model.dto.UserResponse;
import com.maxim.service.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String registration(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("email") String email,
                               @RequestParam("age") Integer age,
                               Model model) {
        UserResponse userResponse = securityService.registration(username, password, firstName, lastName, email, age);
        model.addAttribute("first_name", userResponse.getFirstName());
        model.addAttribute("last_name", userResponse.getLastName());
        model.addAttribute("age", userResponse.getAge());
        model.addAttribute("email", userResponse.getEmail());
        System.out.println("registration-method");
        return "registration-response";
    }
}
