package ru.testproj.book.backend.api.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;

}
