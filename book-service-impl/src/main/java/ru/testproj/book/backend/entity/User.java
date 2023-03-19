package ru.testproj.book.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.security.auth.callback.PasswordCallback;
import javax.validation.constraints.Size;
import java.util.UUID;
import ru.testproj.book.backend.role.Role;

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

    @Column(name = "password")
    private PasswordCallback password;

    @Column(name = "role")
    private Role role;

}
