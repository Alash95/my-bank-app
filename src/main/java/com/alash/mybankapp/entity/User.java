package com.alash.mybankapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String otherName;
    @Column(nullable = false, unique = true)
    @Size(min = 10, max = 10)
    private String accountNumber;
    private double accountBalance;
    @Size(min = 7, max = 15)

    private String phoneNumber;

    private String alternativePhoneNumber;
    @Email
    private String email;
    @Size(min = 4, max = 6)
    private String gender;
    @Size(min = 5, max = 500)
    private String address;
    @Size(min = 3)
    private String religion;
    private Date dateOfBirth;
    @Size(min = 11, max = 11)
    private String bvn;
    @Size(min = 10, max = 10)
    private String referralCode;
    @Column(nullable = false)
    @Size(min = 6)
    private String password;


}
/**
 * Firstname, lastname, othername(optional), accountnumber, accountbalance,
 * phonenumber1, phonenumber2, emailaddress, gender, address, religion,
 * date of birth, bvn, referral code
 */
