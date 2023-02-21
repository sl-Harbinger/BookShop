package ru.testproj.book.backend.repository;

import org.springframework.boot.context.config.ConfigData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.testproj.book.backend.entity.Author;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
   // @Query("select a.name, a.id from Author a where a.name = :name")
    Optional<Author> findAuthorByNameContainsIgnoreCase (@Param("name") String name);



}
