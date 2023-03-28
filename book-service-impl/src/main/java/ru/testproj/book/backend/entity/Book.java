package ru.testproj.book.backend.entity;

import liquibase.diff.ObjectDifferences;
import liquibase.pro.packaged.O;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;


@EqualsAndHashCode
@Data
@Table(name = "db_book_book")
@Entity
public class Book implements Comparable<Book> {

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

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "book")
    private List<Order> order;

    @Size(min = 2, max = 255)
    @Column(name = "title")
    private String title;


    @Column(name = "price")
    private BigDecimal price;

    @Override
    public int compareTo(Book book) {
        int bookTitle = this.title.compareTo(book.title);
        int publisherTitle = this.publisher.getTitle().compareTo(book.publisher.getTitle());
        int publisherCity = this.publisher.getCity().compareTo(book.publisher.getCity());
        int author = this.author.getName().compareTo(book.author.getName());
        return bookTitle + publisherTitle + publisherCity + author;
    }
}
