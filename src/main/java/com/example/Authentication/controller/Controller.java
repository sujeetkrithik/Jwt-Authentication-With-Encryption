package com.example.Authentication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/welcome")
    public String Welcome(){
        return "Welcome to Divum";
    }
}
