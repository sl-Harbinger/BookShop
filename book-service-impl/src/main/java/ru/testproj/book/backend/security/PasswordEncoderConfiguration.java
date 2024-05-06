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

}
