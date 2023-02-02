package ru.testproj.book.backend.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDto  {
    private String id;
    private String publisher;
    private String author;
    private String title;
    private BigDecimal price;




}
