package ru.testproj.book.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.testproj.book.backend.entity.Author;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {

    Optional<Author> findAuthorByNameContainsIgnoreCase(@Param("name") String name);

    @Query("SELECT bo FROM Book bo\n" +
            "LEFT JOIN Author au ON au.id =  bo.author\n" +
            "LEFT JOIN Publisher pu ON pu.id =  bo.publisher\n" +
            "WHERE  UPPER(au.name) LIKE UPPER(:author)")
    Author getAuthorBook(@Param("author") String author);


}
