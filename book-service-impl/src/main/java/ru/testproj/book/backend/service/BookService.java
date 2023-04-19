package ru.testproj.book.backend.service;

import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.api.dto.PagebleResponse;
import java.util.List;
import java.util.UUID;

public interface BookService {

    PagebleResponse<BookDto> getBookAll(int page, int elements);
    BookDto getBookId(UUID id);
    List<BookDto> getBookTitle(String title);
    String createBook(BookDto bookDto);
    List<BookDto> getBookAuthor(String name);


}
