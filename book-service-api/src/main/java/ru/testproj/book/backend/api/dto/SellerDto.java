package ru.testproj.book.backend.api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class SellerDto {
    private UUID id;
    private String name;
    private String position;
}
