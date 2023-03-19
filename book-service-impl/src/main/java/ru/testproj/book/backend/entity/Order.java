package ru.testproj.book.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
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

    @ManyToOne(targetEntity = Seller.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "seller", referencedColumnName = "id")
    private Seller seller;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer", referencedColumnName = "id")
    private Customer customer;

    @ManyToMany(targetEntity = Book.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "book", referencedColumnName = "id")
    private List<Book> book;

    @Column(name = "data")
    private Date data;

    @Column(name = "number")
    private Integer number;



}
