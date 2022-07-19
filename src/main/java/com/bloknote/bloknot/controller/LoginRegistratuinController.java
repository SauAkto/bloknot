package com.bloknote.bloknot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginRegistratuinController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
}
