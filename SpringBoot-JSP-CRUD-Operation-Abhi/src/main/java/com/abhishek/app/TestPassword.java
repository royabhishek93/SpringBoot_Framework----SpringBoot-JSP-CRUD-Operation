package com.abhishek.app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {
	public static BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
     public static void main(String []args){
     String password = "password";		 
     String encrytedPassword = passwordEncoder().encode(password);
     System.out.println("encrytedPassword=="+encrytedPassword);
     }
}
