package ru.testproj.book.backend.api.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String login;
    private String password;

}
