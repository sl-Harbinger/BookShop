package ru.testproj.book.backend.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "db_book_role")
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 25)
    private ERole name;
    @ManyToMany (mappedBy ="role", fetch = FetchType.LAZY)
    private List<User> users;


}
