package com.jisiben.hrms.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class EncryptUtil {
    private static final PasswordEncoder encoder = new Md5PasswordEncoder();

    public static String encrypt(String rawPassword) {
        return encoder.encodePassword(rawPassword, "aaa");
    }

    public static boolean match(String rawPassword, String password) {
        return encoder.isPasswordValid(rawPassword, password, "admin");
    }

    public static void main(String[] args) {
        System.out.println(encrypt("123"));
        System.out.println(match("86888061b399e74e30eeead8c7aab922", "123"));
    }
}
