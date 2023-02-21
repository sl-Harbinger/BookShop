package ru.testproj.book.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.testproj.book.backend.api.dto.PagebleResponse;
import ru.testproj.book.backend.resource.BookResourceImpl;
import org.springframework.stereotype.Service;
import ru.testproj.book.backend.api.dto.AuthorDto;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.entity.Author;
import ru.testproj.book.backend.entity.Book;
import ru.testproj.book.backend.mapper.BookDtoToBookEntityMapper;
import ru.testproj.book.backend.repository.AuthorRepository;
import ru.testproj.book.backend.repository.BookRepository;
import ru.testproj.book.backend.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookDtoToBookEntityMapper mapper;
    private final AuthorRepository authorRepository;

    @Override       //пагинация
    public PagebleResponse getBookAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = bookRepository.getAllBy(pageable);
        PagebleResponse pagebleResponse = new PagebleResponse();
        pagebleResponse.setSize((int) books.getTotalElements());
        pagebleResponse.setHasMore(books.getTotalPages() <= books.getTotalElements());
        pagebleResponse.setData(books.stream()
                .map(mapper::bookEntityToBookDto)
                .collect(Collectors.toList()));
        return pagebleResponse;
    }

    //поиск по id книги
    @Override
    public BookDto getBookId(UUID id) {
        return mapper.bookEntityToBookDto(bookRepository.findBookById(id));
    }

    //создание книги
    @Override
    public String createBook(BookDto bookDto) {
        Book newBook = mapper.bookDtoToBook(bookDto);
        String author = bookDto.getAuthor().getName();
        Author newAuthor = authorRepository.findAuthorByNameContainsIgnoreCase(author)
                .orElse(mapper.authorDtoToAuthorEntity(bookDto.getAuthor()));
        newBook.setAuthor(newAuthor);
        return bookRepository.save(newBook).getId().toString();
    }


}
