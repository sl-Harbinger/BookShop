package ru.testproj.book.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "db_book_order")
@Entity
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    private UUID id;

    @Column(name = "data")
    private Date data;

    @Column(name = "number")
    private Integer number;

    @ManyToOne(targetEntity = Seller.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "seller", referencedColumnName = "id")
    private Seller seller;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer", referencedColumnName = "id")
    private Customer customer;

    @ManyToMany(targetEntity = Book.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "db_book_union_book_order",
            joinColumns = @JoinColumn(name = "order"),
            inverseJoinColumns = @JoinColumn(name = "book"))
    private List<Book> book;

}
