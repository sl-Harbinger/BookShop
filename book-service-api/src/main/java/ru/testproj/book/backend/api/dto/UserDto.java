package ru.testproj.book.backend.api.dto;

import lombok.Data;

import javax.security.auth.callback.PasswordCallback;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String login;
    private PasswordCallback password;
    private String email;
    private String role;
}
