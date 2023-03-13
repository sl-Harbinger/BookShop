package ru.testproj.book.backend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.webjars.NotFoundException;
import ru.testproj.book.backend.api.dto.AuthorDto;
import ru.testproj.book.backend.api.dto.PagebleResponse;
import ru.testproj.book.backend.mapper.AuthorMapper;
import org.springframework.stereotype.Service;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.entity.Author;
import ru.testproj.book.backend.entity.Publisher;
import ru.testproj.book.backend.entity.Book;
import ru.testproj.book.backend.mapper.BookMapper;
import ru.testproj.book.backend.mapper.PublisherMapper;
import ru.testproj.book.backend.repository.AuthorRepository;
import ru.testproj.book.backend.repository.BookRepository;
import ru.testproj.book.backend.repository.PublisherRepository;
import ru.testproj.book.backend.resource.PagebleResponseImpl;
import ru.testproj.book.backend.service.BookService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorMapper authorMapper;
    private final PublisherMapper publisherMapper;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final PagebleResponseImpl response;


    @Override       //вывод всех книг + пагинация
    public PagebleResponse<BookDto> getBookAll(int page, int elements) {
        return response.getPageable(page, elements);
    }

    //поиск по id книги
    @Override
    public BookDto getBookId(UUID id) {
        return bookMapper.bookEntityToBookDto(bookRepository.findBookById(id));
    }

    //поиск книги по названию
    @Override
    public List<BookDto> getBookTitle(String title) {
        List<Book> book1 = bookRepository.findBookByTitleContainsIgnoreCase(title);

        return book1.stream()
                .map(bookMapper::bookEntityToBookDto)
                .collect(Collectors.toList());
    }


    //создание книги
//    нужна проверка на дубль автор издание цена
    @Override
    public String createBook(BookDto bookDto) {
        Book newBook = bookMapper.bookDtoToBook(bookDto);
//        проверка автора, если есть подсунуть с БД, иначе новый
        String author = bookDto.getAuthor().getName();
        Author newAuthor = authorRepository.findAuthorByNameContainsIgnoreCase(author)
                .orElse(authorMapper.authorDtoToAuthorEntity(bookDto.getAuthor()));
//        проверка издательства, если есть подсунуть с БД, иначе новый
        String title = bookDto.getPublisher().getTitle();
        String city = bookDto.getPublisher().getCity();
        Publisher newPublisher = publisherRepository.findPublisherByTitleContainsIgnoreCaseAndCityContainsIgnoreCase(title, city)
                .orElse(publisherMapper.publisherDtoToPublisherEntity(bookDto.getPublisher()));
        newBook.setAuthor(newAuthor);
        newBook.setPublisher(newPublisher);
        log.info("книга создана");
        // if (newBook==bookDto) это дубль
        return bookRepository.save(newBook).getId().toString();
    }


    //          поиск книги по автору
    @Override
    public List<BookDto> getBookAuthor(String author) {
        Author author1 = authorRepository.findAuthorByNameContainsIgnoreCase(author)
                .orElseThrow(() -> new NotFoundException("Автора нет"));

        return author1.getBook().stream()
                .map(bookMapper::bookEntityToBookDto)
                .collect(Collectors.toList());
    }


}
