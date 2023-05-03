package com.alash.mybankapp.service;

import com.alash.mybankapp.entity.User;
import com.alash.mybankapp.payload.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User registerUser(UserRequest userRequest);

    List<User> fetchAllRegisteredUser();

}
