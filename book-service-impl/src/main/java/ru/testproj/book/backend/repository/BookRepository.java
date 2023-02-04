package ru.testproj.book.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.testproj.book.backend.entity.Book;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    @Query(value = "SELECT  b.id, b.id_publisher, b.id_author, b.title, b.price\n" +
            "from db_book_book b " ,nativeQuery = true)
    List<Book> getAll();


}
