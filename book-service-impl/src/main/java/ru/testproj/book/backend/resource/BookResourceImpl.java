package ru.testproj.book.backend.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.testproj.book.backend.api.constant.UrlConstants;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.api.resource.BookResource;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(UrlConstants.MAIN_URL + UrlConstants.BOOK)
public class BookResourceImpl implements BookResource {


    @Override
    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getBookAll() {


        return null;
    }




}
