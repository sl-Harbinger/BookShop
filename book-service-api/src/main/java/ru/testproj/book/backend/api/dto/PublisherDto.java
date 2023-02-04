package ru.testproj.book.backend.api.dto;

import lombok.Data;

@Data
public class PublisherDto {
    private String id;
    private String publisher;
    private String author;
}
