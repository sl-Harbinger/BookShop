package ru.testproj.book.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.entity.Author;
import ru.testproj.book.backend.entity.Book;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    @Query("SELECT b FROM Book b JOIN FETCH b.author JOIN fetch b.publisher")
    List<Book> getBookAll();



    // книга по id
    @Query("select b from Book b JOIN FETCH b.author JOIN fetch b.publisher where b.id = :id")
    Book findBookById(@Param("id") UUID id);


    @Query("select b from Book b JOIN FETCH b.author JOIN fetch b.publisher where b.author = :author")
    Author findBookByAuthor(@Param("author") String author);


}




// fk_db_book_book_id_author_db_book_author_id


// b.title, Author.name, Publisher.title, Publisher.city, b.price