package ru.testproj.book.backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;


@Data
@Table(name = "db_book_book")
@Entity
public class Book {


    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    // заглушки

    private String title;
    private BigDecimal price;



}
