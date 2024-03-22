package ru.testproj.book.backend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CustomerDto {

    private UUID id;
    private String name;
    private String email;
}

