package ru.testproj.book.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoderConfiguration  {


    @Bean
    public BCryptPasswordEncoder passwordEncoder1() {
        return new BCryptPasswordEncoder();
    }



//    @Override
//    public String encode(CharSequence rawPassword) {
//        return null;
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        return false;
//    }
//
//    @Override
//    public boolean upgradeEncoding(String encodedPassword) {
//        return PasswordEncoder.super.upgradeEncoding(encodedPassword);
//    }
}
