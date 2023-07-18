package com.zikan.todomanagementproject.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl {

    public static void main(String[] args) {
//        lets create an instance of password encoder

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("zik"));

        System.out.println(passwordEncoder.encode("sunny"));

        System.out.println(passwordEncoder.encode("maria"));

    }
}
