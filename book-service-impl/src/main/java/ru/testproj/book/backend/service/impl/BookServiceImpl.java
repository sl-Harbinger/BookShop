package ru.testproj.book.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.testproj.book.backend.api.dto.AuthorDto;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.api.dto.PublisherDto;
import ru.testproj.book.backend.entity.Author;
import ru.testproj.book.backend.entity.Book;
import ru.testproj.book.backend.entity.Publisher;
import ru.testproj.book.backend.repository.BookRepository;
import ru.testproj.book.backend.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service

public class BookServiceImpl implements BookService {
//инверсия контроля
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private BookDto createBookDto (Book book){
        AuthorDto authorDto = new AuthorDto();
        Author author1 = book.getAuthor();
        authorDto.setName(author1.getName());
        authorDto.setId(author1.getId());

        PublisherDto publisherDto = new PublisherDto();
        Publisher publisher1 = book.getPublisher();
        publisherDto.setId(publisher1.getId());
        publisherDto.setTitle(publisher1.getTitle());
        publisherDto.setCity(publisher1.getCity());

        BookDto dto = new BookDto();
        dto.setTitle(book.getTitle());
        dto.setId(UUID.fromString(book.getId().toString())); //ооп
        dto.setPrice(book.getPrice());
        dto.setAuthor(authorDto);
        dto.setPublisher(publisherDto);
        return dto;
    }


    @Override
    public List<BookDto> getAll() {
        List<Book> books = bookRepository.getAll();
        List<BookDto> dtos = new ArrayList<>();

        for (Book book:books) {
            dtos.add(createBookDto(book));
        }
        return dtos;
    }



//    @Override
//
//    public BookDto getBookId() {
//        return null;
//  }



}
