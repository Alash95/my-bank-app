package com.alash.mybankapp.repository;

import com.alash.mybankapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    User findByAccountNumber(String accountNumber);

    boolean existsByAccountNumber(String accountNumber);




}
