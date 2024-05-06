package ru.testproj.book.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "db_book_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "db_book_union_user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Collection<Name> name;
    
    @Column(name = "name")
    private String name;
}
