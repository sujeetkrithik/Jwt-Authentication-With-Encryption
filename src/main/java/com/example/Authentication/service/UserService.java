package com.example.Authentication.service;

import com.example.Authentication.entity.User;
import com.example.Authentication.repository.UserRepository;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(@RequestBody User user) {
        User user1= new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setRole(user.getRole());
        return userRepository.save(user1);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
