package ru.testproj.book.backend.api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PublisherDto {
    private UUID id;
    private String title;
    private String city;
}
