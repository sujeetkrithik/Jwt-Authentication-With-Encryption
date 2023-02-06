package com.example.Authentication.service;

import com.example.Authentication.entity.User;
import com.example.Authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        JwtRequest jwtRequest = new JwtRequest();
//        if(username.equals(jwtRequest.getUsername()))
//        {
//            return new User(jwtRequest.getUsername(), jwtRequest.getPassword(), new ArrayList<>());
//
//        }
//        else
//        {
//            throw new UsernameNotFoundException("User not found!");
//        }

       Optional<User> optionalUser= userRepository.findByUsername(username);
       if(optionalUser.isEmpty())
       {
           throw new UsernameNotFoundException("user not found with "+username);
       }
        CustomUserDetail customUserDetail = new CustomUserDetail();
       customUserDetail.setUser(optionalUser.get());
        return customUserDetail;
    }
}
