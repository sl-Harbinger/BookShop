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

    @ManyToOne(targetEntity = Author.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "author", referencedColumnName = "id")
    private Author author;
    @ManyToOne(targetEntity = Publisher.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher", referencedColumnName = "id")
    private Publisher publisher;

    private String title;
    private BigDecimal price;


}
