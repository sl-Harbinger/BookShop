package ru.testproj.book.backend.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.testproj.book.backend.entity.Book;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

//    вывод всех книг
//    @Query("SELECT b FROM Book b JOIN FETCH b.author JOIN fetch b.publisher")
    Page<Book> getAllBy(Pageable pageable);

    // книга по id
    @Query("select b from Book b JOIN FETCH b.author JOIN fetch b.publisher where b.id = :id")
    Book findBookById(@Param("id") UUID id);





}

