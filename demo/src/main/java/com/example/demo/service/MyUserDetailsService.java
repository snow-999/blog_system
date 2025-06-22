package com.example.demo.service;


import com.example.demo.entity.UserEntity;
import com.example.demo.model.MyUserPrincipal;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(userName);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Name Not Found");
        }
        return new MyUserPrincipal(user);
    }
}


