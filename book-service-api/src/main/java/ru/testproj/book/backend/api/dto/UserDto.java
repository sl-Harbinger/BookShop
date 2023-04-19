package ru.testproj.book.backend.api.dto;

import lombok.Data;

import javax.security.auth.callback.PasswordCallback;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String login;
    private String password;
    private Enum ERole;


}
