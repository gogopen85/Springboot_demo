package com.example.demo.service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public void save(User user){
        if(!userRepository.findByUsername(user.getUsername()).isPresent()){
            user.setPassword(passwordEncoder().encode(user.getPassword()));
            userRepository.save(user);
        }
    }

    public Optional<User> getUser(String username){
        return userRepository.findByUsername(username);
    }
}
