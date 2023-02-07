package ru.testproj.book.backend.service;

import ru.testproj.book.backend.api.dto.BookDto;

import java.util.List;
import java.util.UUID;

public interface BookService {

    List<BookDto> getAll();
//    BookDto getBookId();

}
