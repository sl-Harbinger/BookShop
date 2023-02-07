package ru.testproj.book.backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Table(name = "db_book_publisher")
@Entity
public class Publisher {

    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    private String title;
    private String city;
}
