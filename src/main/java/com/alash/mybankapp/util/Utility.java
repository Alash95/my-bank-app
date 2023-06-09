package com.alash.mybankapp.util;

import java.time.Year;

public class Utility {

    public static String generateAccountNumber() {

        //first four digits = current year
        //next 6 digits will be any random number

        Year year = Year.now();
        System.out.println(year);
        int from = 100000;
        int to = 999999;
        int randomNumber = (int)Math.floor(Math.random()*(to-from+1)+from);
        System.out.println(randomNumber);
        StringBuilder accountNumber = new StringBuilder();
        accountNumber.append(year).append(randomNumber);
        System.out.println(accountNumber);
        return accountNumber.toString();
    }

    public static void main(String[] args) {
        generateAccountNumber();
    }
}
