package ru.testproj.book.backend.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.testproj.book.backend.api.dto.JwtRequest;
import ru.testproj.book.backend.api.dto.JwtResponse;
import ru.testproj.book.backend.api.dto.RegistrationUserDto;
import ru.testproj.book.backend.security.JwtTokenUtils;
import ru.testproj.book.backend.service.impl.AuthService;
import ru.testproj.book.backend.service.impl.UserService;



@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

//    @PostMapping("/registration")
//    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
//        return authService.createNewUser(registrationUserDto);
//    }


}
