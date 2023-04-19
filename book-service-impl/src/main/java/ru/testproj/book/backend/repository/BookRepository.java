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

    //    вывод всех книг с пагинацией
    Page<Book> getAllBy(Pageable pageable);

    // книга по id
    @Query("select b from Book b JOIN FETCH b.author JOIN fetch b.publisher where b.id = :id")
    Book findBookById(@Param("id") UUID id);

    // книга по названию
    @Query("select b from Book b JOIN FETCH b.author JOIN fetch b.publisher where UPPER(b.title) = UPPER(:title)")
    Book getBookTitle(@Param("title") String title);
    List<Book> findBookByTitleContainsIgnoreCase(@Param("name") String name);

    @Query("select bo " +
            "from Book bo" +
            " left join  Author au on bo.author = au.id " +
            "left join  Publisher pu on bo.publisher = pu.id " +
            "where bo.title =(:titleBook)" +
            "and pu.city =(:city)" +
            "and (pu.title=(:title))" +
            "and (au.name=(:author))")
    Book getBook(@Param("titleBook") String titleBook,
                 @Param("city") String city,
                 @Param("title") String title,
                 @Param("author") String author);


}

