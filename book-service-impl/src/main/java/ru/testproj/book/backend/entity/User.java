package ru.testproj.book.backend.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;
import java.util.UUID;



@Table(name = "db_book_user",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "login")
        })
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    private UUID id;

    @Size(min = 2, max = 255, message = "Не меньше 5 знаков")
    @Column(name = "login")
    private String login;

    @Column(name = "password" )
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> role;

}
