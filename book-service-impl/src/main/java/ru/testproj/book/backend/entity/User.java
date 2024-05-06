package ru.testproj.book.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.UUID;

@Data
@Table(name = "db_book_user")
@Entity
@NoArgsConstructor
public class User  {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    private UUID id;

    @Size(min = 2, max = 255)
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "db_book_union_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;

}
