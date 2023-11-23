package ru.testproj.book.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.security.auth.callback.PasswordCallback;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "db_book_user")
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    private UUID id;

    @Size(min = 2, max = 255)
    @Column(name = "login")
    private String login;

    @Transient
    @Column(name = "password")
    private String password;


    @ManyToMany
    @JoinTable(
            name = "db_book_union_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;

}
