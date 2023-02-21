package ru.testproj.book.backend.api.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.math.BigDecimal;
import java.util.UUID;


@Data
public class BookDto  {
    private UUID id;
    private PublisherDto publisher;
    private AuthorDto author;
    private String title;
    private BigDecimal price;


}

