package ru.testproj.book.backend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.security.auth.callback.PasswordCallback;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserDto {
//    private UUID id;
    private String username;
    private String email;
    private String role;
}
