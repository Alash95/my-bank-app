package com.alash.mybankapp.service.impl;

import com.alash.mybankapp.entity.User;
import com.alash.mybankapp.payload.DepositRequest;
import com.alash.mybankapp.payload.TransferRequest;
import com.alash.mybankapp.payload.UserRequest;
import com.alash.mybankapp.payload.WithdrawalRequest;
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
    public List<User> findAllRegisteredUser() {
        return userRepository.findAll();
    }

    public User fetchUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "Deleted Successfully";

    }

    @Override
    public User findUserByAccountNumber(String accountNumber) {
        boolean isAccountExist = userRepository.existsByAccountNumber(accountNumber);

        if (isAccountExist) {
            return userRepository.findByAccountNumber(accountNumber);

        }
        else {
            return null;
        }
    }

    @Override
    public String depositUsingAccountNumber(String accountNumber, DepositRequest request) {
        boolean isAccountExist = userRepository.existsByAccountNumber(accountNumber);

        if (isAccountExist) {
            User user = userRepository.findByAccountNumber(accountNumber);
            user.setAccountBalance(user.getAccountBalance()+request.getAmount());
            userRepository.save(user);
            return "Your new balance is: " + user.getAccountBalance();
        }
        else {
            return null;
        }
    }

    @Override
    public String withdrawalUsingAccountNumber(String accountNumber, WithdrawalRequest request) {
        boolean isAccountExist = userRepository.existsByAccountNumber(accountNumber);

        if (isAccountExist) {
            User user = userRepository.findByAccountNumber(accountNumber);
            if (user.getAccountBalance() > request.getAmount()){
                user.setAccountBalance(user.getAccountBalance()-request.getAmount());
                userRepository.save(user);
                return request.getAmount() + " withdrawn successfully";
            }
            else{
                return "Insufficient funds";
            }
        }
        else {
            return "Account not found";
        }
    }

    @Override
    public String transferRequest(String accountNumber, TransferRequest request) {
        boolean isUserAccountExist = userRepository.existsByAccountNumber(accountNumber);
        boolean isRecipientAccountExist = userRepository.existsByAccountNumber(request.getAccountNumber());
        User user = userRepository.findByAccountNumber(accountNumber);
        User user1 = userRepository.findByAccountNumber(request.getAccountNumber());

        if (isUserAccountExist && isRecipientAccountExist) {
            if (user.getAccountBalance() > request.getAmount()) {
                user.setAccountBalance(user.getAccountBalance() - request.getAmount());
                userRepository.save(user);

                user1.setAccountBalance(user1.getAccountBalance() + request.getAmount());
                userRepository.save(user1);
                return "Transfer Successful!"+" You've sent "+"#" +request.getAmount()+" to "+ user1.getFirstName()+" "+user1.getLastName();
            }
            else {
                return "Insufficient funds";
            }
        }
        else {
            return "Account not found";
        }
    }

    @Override
    public String balanceEnquiry(String accountNumber) {
        boolean isAccountExist = userRepository.existsByAccountNumber(accountNumber);
        User user = userRepository.findByAccountNumber(accountNumber);

        if (isAccountExist) {
            return user.getFirstName() + " " + user.getLastName() + " " + user.getOtherName() + " " +
                    user.getAccountBalance();

        }
        else {
            return "Account not found";
        }
    }

}
