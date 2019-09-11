package com.jisiben.hrms.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class EncryptUtil {
    private static final PasswordEncoder encoder = new Md5PasswordEncoder();

    public static String encrypt(String presentedPassword, String userName) {
        return encoder.encodePassword(presentedPassword, userName);
    }

    public static boolean match(String rawPassword, String password, String userName) {
        return encoder.isPasswordValid(rawPassword, password, userName);
    }

    public static void main(String[] args) {
        System.out.println(encrypt("123", "gary"));
        System.out.println(match("010787e658be76708b40aa336e482293", "123", "gary"));
    }
}
