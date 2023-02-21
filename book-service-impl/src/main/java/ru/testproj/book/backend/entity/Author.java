package ru.testproj.book.backend.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Table(name = "db_book_author")
@Entity

public class Author {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    private UUID id;


    @Size(min = 2, max = 255)
    @Column(name = "name")
    private String name;



}
