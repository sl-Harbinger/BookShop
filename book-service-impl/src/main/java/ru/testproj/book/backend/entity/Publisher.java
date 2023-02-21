package ru.testproj.book.backend.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Table(name = "db_book_publisher")
@Entity
public class Publisher {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    private UUID id;
    @Size(min = 2, max = 200)
    @Column(name = "title")
    private String title;
    @Size(min = 2, max = 100)
    @Column(name = "city")
    private String city;
}
