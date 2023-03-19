package ru.testproj.book.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Table(name = "db_book_unit_book_order")
@Entity
@NoArgsConstructor
public class UnitBookOrder {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    private UUID id;


    @ManyToOne(targetEntity = Book.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "book", referencedColumnName = "id")
    private Book book;

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order", referencedColumnName = "id")
    private Order order;
}
