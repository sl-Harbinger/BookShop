package ru.testproj.book.backend.service;

import org.springframework.data.domain.Pageable;
import ru.testproj.book.backend.api.dto.AuthorDto;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.api.dto.PagebleResponse;

import java.util.List;
import java.util.UUID;

public interface BookService {

    PagebleResponse getBookAll(int size, int page);
    BookDto getBookId(UUID id);
    String createBook(BookDto bookDto);


}
