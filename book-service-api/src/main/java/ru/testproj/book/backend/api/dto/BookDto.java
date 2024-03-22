package ru.testproj.book.backend.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;


@Data
public class BookDto {
    private UUID id;
    private PublisherDto publisher;
    private AuthorDto author;
    private String title;
    private BigDecimal price;

    public String toString() {
        return "Автор: " + author.getName() +
                "\n Название: " + title +
                "\n Издательство: " + publisher.getTitle();
    }

}

