package com.alash.mybankapp.service.impl;

import com.alash.mybankapp.entity.User;
import com.alash.mybankapp.payload.UserRequest;
import com.alash.mybankapp.repository.UserRepository;
import com.alash.mybankapp.service.UserService;
import com.alash.mybankapp.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(UserRequest userRequest) {

//        check if the user already exists by email
//        boolean isExist = userRepository.existsByEmail(userRequest.getEmail());

//        save the record
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setOtherName(userRequest.getOtherName());
        user.setAccountNumber(Utility.generateAccountNumber());
        user.setAccountBalance(0.0);
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setAlternativePhoneNumber(userRequest.getAlternativePhoneNumber());
        user.setEmail(userRequest.getEmail());
        user.setGender(userRequest.getGender());
        user.setAddress(userRequest.getAddress());
        user.setReligion(userRequest.getReligion());
        user.setBvn(userRequest.getBvn());
        user.setReferralCode(userRequest.getReferralCode());
        user.setPassword(userRequest.getPassword());

        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAllRegisteredUser() {
        return userRepository.findAll();
    }

}
