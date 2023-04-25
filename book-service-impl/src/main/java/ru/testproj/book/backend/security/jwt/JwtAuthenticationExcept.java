package ru.testproj.book.backend.security.jwt;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
public class JwtAuthenticationExcept extends AuthenticationException {
    private HttpStatus httpStatus;
    public JwtAuthenticationExcept(String msg) {
        super(msg);
    }
    public JwtAuthenticationExcept(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }
}