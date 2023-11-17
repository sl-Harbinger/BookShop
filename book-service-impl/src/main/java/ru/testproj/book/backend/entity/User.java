package ru.testproj.book.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.security.auth.callback.PasswordCallback;
import javax.validation.constraints.Size;
import java.util.Collection;
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
    private PasswordCallback password;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "db_book_union__user_role",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "role"))
    private Collection<Role> roles;
}
