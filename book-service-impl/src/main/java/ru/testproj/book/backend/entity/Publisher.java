package ru.testproj.book.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "db_book_publisher")
@Entity
@NoArgsConstructor
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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "publisher")
    private List<Book> book;
}
