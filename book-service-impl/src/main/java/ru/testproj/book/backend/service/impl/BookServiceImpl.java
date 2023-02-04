package ru.testproj.book.backend.service.impl;

import liquibase.pro.packaged.I;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.entity.Book;
import ru.testproj.book.backend.repository.BookRepository;
import ru.testproj.book.backend.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
//инверсия контроля
    private BookRepository bookRepository;



    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> getAll() {
        List<Book> books = bookRepository.getAll();
        List<BookDto> dtos = new ArrayList<>();
        for (Book book:books) {
            BookDto dto = new BookDto();
            dto.setTitle(book.getTitle());
            dto.setId(book.getId().toString()); //ооп
            dto.setPrice(book.getPrice());
            dto.setAuthor(book.getId_author().toString());
            dto.setPublisher(book.getId_publisher().toString());
            dtos.add(dto);
        }

        return dtos;
    }


}
