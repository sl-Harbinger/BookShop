package ru.testproj.book.backend.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.testproj.book.backend.api.constant.UrlConstants;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.api.resource.BookResource;
import ru.testproj.book.backend.service.BookService;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


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

    @Override
    @GetMapping("/id")
    public ResponseEntity<List<BookDto>> getBookId() {
        return null;
    }


}
//public class Test{
//    int wwww;
//    Test(int wwww){
//        this.wwww = wwww;
//    }
//
//    public void setWwww(int wwww) {
//        this.wwww = wwww;
//    }
//}
