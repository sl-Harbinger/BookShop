package ru.testproj.book.backend.api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AuthorDto {
    private UUID id;
    private String name;
}
