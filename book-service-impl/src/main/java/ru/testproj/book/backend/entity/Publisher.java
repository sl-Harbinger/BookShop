package ru.testproj.book.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Table(name = "db_book_publisher")
@Entity
public class Publisher {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    private UUID id;
    @Column(name = "title")
    private String title;
    @Column(name = "city")
    private String city;
}
