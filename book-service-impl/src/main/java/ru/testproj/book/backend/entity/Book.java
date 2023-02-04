package ru.testproj.book.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;


@Data
@Table(name = "db_book_book")
@Entity
public class Book {


    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    private UUID id_author;
    private UUID id_publisher;
    private String title;
    private BigDecimal price;




}
