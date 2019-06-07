package com.example.demo;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    @Bean
    public CommandLineRunner setupDefaultUser(UserService userService) {
        return args -> {
            userService.save(new User("user", "user" ,"password", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
