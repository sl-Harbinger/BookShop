package ru.testproj.book.backend.service;

import ru.testproj.book.backend.api.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAll();
}
