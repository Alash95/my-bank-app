package com.alash.mybankapp.controller;

import com.alash.mybankapp.entity.User;
import com.alash.mybankapp.payload.UserRequest;
import com.alash.mybankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User registerUser(@RequestBody UserRequest userRequest){
        return userService.registerUser(userRequest);
    }

    @GetMapping
    public List<User> fetchAllRegisteredUsers(){
        return userService.fetchAllRegisteredUser();
    }





}
