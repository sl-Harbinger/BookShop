package ru.testproj.book.backend.api.dto;

import lombok.Data;

@Data
public class RegistrationUserDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
   // private Collection<?> role;
}
