package ru.testproj.book.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "db_book_customer")
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    private UUID id;
    @Size(min = 2, max = 200)
    @Column(name = "name")
    private String name;
    @Email
    @Column(name = "email")
    private String email;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Order> order;
}
