package ru.testproj.book.backend.entity;


import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



@Entity
@Table(name = "db_book_role")
@Data
public class Role{
    @Id
    @Column(name = "id")
    private String id;

    @ManyToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> user;



 }
