package com.jisiben.hrms.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class EncryptUtil {
    private static final String SITE_WIDE_SECRET = "RouSiMian";
    private static final PasswordEncoder encoder = new StandardPasswordEncoder(
            SITE_WIDE_SECRET);

    public static String encrypt(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public static boolean match(String rawPassword, String password) {
        return encoder.matches(rawPassword, password);
    }


//    public static void main(String[] args) {
//        System.out.println(encrypt("kanglanlaowu"));
//        System.out.println(match("kanglanlaowu","3ff12e1952926aadfeb8fa23c0c49534aec58b8ac19c9cb318ee658006cf09fcdeb8614fee674e16"));
//    }
}
