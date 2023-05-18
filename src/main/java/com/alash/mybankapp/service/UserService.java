package com.alash.mybankapp.service;

import com.alash.mybankapp.entity.User;
import com.alash.mybankapp.payload.DepositRequest;
import com.alash.mybankapp.payload.TransferRequest;
import com.alash.mybankapp.payload.UserRequest;
import com.alash.mybankapp.payload.WithdrawalRequest;

import java.util.List;

public interface UserService {

    User registerUser(UserRequest userRequest);

    List<User> findAllRegisteredUser();

    User fetchUserById(Long id);
    String deleteUserById(Long id);

    User findUserByAccountNumber(String accountNumber);

    String depositUsingAccountNumber(String accountNumber,DepositRequest request);

    String withdrawalUsingAccountNumber(String accountNumber, WithdrawalRequest request);

    String transferRequest(String accountNumber, TransferRequest request);

    String balanceEnquiry(String accountNumber);




}
