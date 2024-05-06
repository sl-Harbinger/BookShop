package ru.testproj.book.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
    
    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;


//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
//    private List<Order> order;
}
