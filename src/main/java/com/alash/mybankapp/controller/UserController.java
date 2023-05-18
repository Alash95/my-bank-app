package com.alash.mybankapp.controller;

import com.alash.mybankapp.entity.User;
import com.alash.mybankapp.payload.DepositRequest;
import com.alash.mybankapp.payload.TransferRequest;
import com.alash.mybankapp.payload.UserRequest;
import com.alash.mybankapp.payload.WithdrawalRequest;
import com.alash.mybankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserRequest userRequest){
        return userService.registerUser(userRequest);
    }

    @GetMapping("/users")
    public List<User> fetchAllRegisteredUsers(){
        return userService.findAllRegisteredUser();
    }

    @GetMapping("/accountNumber")
    public User fetchUserByAccountNumber(@RequestParam(name = "accountNumber", required = true) String accountNumber) {
        return userService.findUserByAccountNumber(accountNumber);
    }

    @PutMapping("/deposit/{accountNumber}")
    public String depositUsingAccountNumber(@PathVariable String accountNumber, @RequestBody DepositRequest request){
        return userService.depositUsingAccountNumber(accountNumber, request);
    }

    @PutMapping("/withdraw/{accountNumber}")
    public String withdrawUsingAccountNumber(@PathVariable String accountNumber, @RequestBody WithdrawalRequest request) {
        return userService.withdrawalUsingAccountNumber(accountNumber, request);
    }

    @PutMapping("/transfer/{accountNumber}")
    public String transferRequest(@PathVariable String accountNumber, @RequestBody TransferRequest request) {
        return userService.transferRequest(accountNumber, request);
    }

    @GetMapping("/enquiry")
    public String balanceEnquiry(@RequestParam(value = "enquiry") String accountNumber) {
        return userService.balanceEnquiry(accountNumber);
    }









}
