package com.maxim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {
    @PostMapping
    public String security(){
        System.out.println("registration-method");
        return "registration-response";
    }

}
