package ru.testproj.book.backend.resource;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.testproj.book.backend.api.constant.UrlConstants;
import ru.testproj.book.backend.api.dto.AuthorDto;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.api.dto.PagebleResponse;
import ru.testproj.book.backend.api.resource.BookResource;
import ru.testproj.book.backend.service.BookService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping(UrlConstants.MAIN_URL + UrlConstants.BOOK)
public class BookResourceImpl implements BookResource {
    private final BookService bookService;

    //вывод всех книг
    @Override
    @GetMapping("/all")
    public ResponseEntity<PagebleResponse<BookDto>> getBookAll(int page, int elements) {
        PagebleResponse<BookDto> bookAll = bookService.getBookAll(page, elements);
        return ResponseEntity.ok(bookAll);
    }

    // Поиск книги по id
    @Override
    @GetMapping("/id")
    public ResponseEntity<BookDto> getBookId(@RequestParam UUID id) {
        BookDto bookDto = bookService.getBookId(id);
        return ResponseEntity.ok(bookDto);
    }
// Поиск книги но названию
    @Override
    @GetMapping("/title")
    public ResponseEntity<List<BookDto>> getBookTitle(@RequestParam String title) {
        List<BookDto> bookDtoList = bookService.getBookTitle(title);
        return ResponseEntity.ok(bookDtoList);
    }

    //    Добавление книги
    @Override
    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.createBook(bookDto));
    }

    // поиск по автору
    @Override
    @GetMapping("/author")
    public ResponseEntity<List<BookDto>> getBookAuthor(@RequestParam String author) {
        List<BookDto> bookDtoList = bookService.getBookAuthor(author);
        return ResponseEntity.ok(bookDtoList);

    }

}

