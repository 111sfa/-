package com.demo.hotelsystem.controller;

import com.demo.hotelsystem.entity.User;
import com.demo.hotelsystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> data) {
        User user = userMapper.login(data.get("username"), data.get("password"));
        if (user != null) {
            return "success";
        } else {
            return "fail";
        }
    }
}