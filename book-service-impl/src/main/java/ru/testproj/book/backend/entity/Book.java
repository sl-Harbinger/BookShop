package ru.testproj.book.backend.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;


@Data
@Table(name = "db_book_book")
@Entity
public class Book {


    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    private UUID id;

    @ManyToOne(targetEntity = Author.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author", referencedColumnName = "id")
    private Author author;
    @ManyToOne(targetEntity = Publisher.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher", referencedColumnName = "id")
    private Publisher publisher;

    @Size(min = 2, max = 255)
    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;


}
