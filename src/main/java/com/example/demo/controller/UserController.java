package com.example.demo.controller;

import com.example.demo.common.CommonResponseEntity;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.pojos.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.UserService;

import java.util.Arrays;
import java.util.regex.Pattern;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    CommonResponseEntity res = new CommonResponseEntity();

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody UserRegistration userRegistration){
        if("".equals(userRegistration.getName()))
            return res.resBadRequest("아이디는 공백이 될 수 없습니다.");
        else if("".equals(userRegistration.getUsername()))
            return res.resBadRequest("이름은 공백이 될 수 없습니다.");
        else if(!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation()))
            return res.resBadRequest("비밀번호가 일치하지 않습니다.");

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        if(pattern.matcher(userRegistration.getUsername()).find())
            return res.resBadRequest("아이디에는 특수문자가 포함될 수 없습니다.");

        userService.save(new User(userRegistration.getUsername(), userRegistration.getName(),userRegistration.getPassword(), Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));

        return res.resSuccess("가입완료");
    }
}
