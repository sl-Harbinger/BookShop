package ru.testproj.book.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.repository.BookRepository;
import ru.testproj.book.backend.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
//инверсия контроля
    private BookRepository bookRepository;

    public BookServiceImpl(BookServiceImpl bookRepository) {

    }

    @Override
    public List<BookDto> getAll() {

        return null;
    }
}
