package ru.testproj.book.backend.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.testproj.book.backend.api.constant.UrlConstants;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.api.resource.BookResource;
import ru.testproj.book.backend.service.BookService;


import java.util.List;



@RestController
@RequestMapping(UrlConstants.MAIN_URL + UrlConstants.BOOK)
public class BookResourceImpl implements BookResource {

    private BookService bookService;
   // ..конструктор
    public BookResourceImpl(BookService bookService){
        this.bookService = bookService;

    }


    @Override
    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getBookAll() {
        List<BookDto> bookAll = bookService.getAll();

        return ResponseEntity.ok(bookAll);
    }


//    @Override
//    @GetMapping("/id")
//    public BookDto getBookId(UUID id) {
//        return bookService.getBookId();
//    }


}

