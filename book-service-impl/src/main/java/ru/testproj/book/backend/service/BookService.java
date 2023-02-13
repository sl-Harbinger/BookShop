package ru.testproj.book.backend.service;

import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {

    List<BookDto> getBookAll();
    BookDto getBookId(UUID id);
//    addBookId();

}
