package ru.testproj.book.backend.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.testproj.book.backend.api.constant.UrlConstants;
import ru.testproj.book.backend.api.dto.AuthorDto;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.api.dto.PagebleResponse;
import ru.testproj.book.backend.api.resource.BookResource;
import ru.testproj.book.backend.entity.Book;
import ru.testproj.book.backend.service.BookService;


import java.util.List;
import java.util.UUID;


@RestController

@RequestMapping(UrlConstants.MAIN_URL + UrlConstants.BOOK)
public class BookResourceImpl implements BookResource {

    private BookService bookService;

    // ..конструктор
    public BookResourceImpl(BookService bookService) {
        this.bookService = bookService;
    }

    //вывод всех книг
    @Override
    @GetMapping("/all")
    public ResponseEntity<PagebleResponse> getBookAll(int size, int page) {
        PagebleResponse bookAll = bookService.getBookAll(size, page);
        return ResponseEntity.ok(bookAll);
    }

    // Поиск книги по id
    @Override
    @GetMapping("/id")
    public ResponseEntity<BookDto> getBookId(@RequestParam UUID id) {
        BookDto bookDto = bookService.getBookId(id);
        return ResponseEntity.ok(bookDto);
    }

    //    Добавление книги
    @Override
    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.createBook(bookDto));
    }

// поиск по автору
//    @Override
//    @GetMapping("/author")
//    public ResponseEntity<AuthorDto> getNameAuthor(@RequestParam String name) {
//        AuthorDto authorDto = bookService.getNameAuthor(name);
//        return ResponseEntity.ok(authorDto);
//    }
}

