package com.example.Authentication.controller;

import com.example.Authentication.entity.User;
import com.example.Authentication.repository.UserRepository;
import com.example.Authentication.service.UserService;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
         return userService.save(user);
    }

    @GetMapping("/allUser")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getUser")
    public Optional<User> getUser(@Autowired UsernamePasswordAuthenticationToken userPrincipal){
        return userRepository.findByUsername(userPrincipal.getName());
    }

}
