package ru.testproj.book.backend.api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String name;
    private Enum role;
}
