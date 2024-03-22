package ru.testproj.book.backend.service.impl;

import com.sun.xml.bind.v2.runtime.reflect.Lister;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.api.dto.PagebleResponse;
import ru.testproj.book.backend.entity.Author;
import ru.testproj.book.backend.entity.Book;
import ru.testproj.book.backend.entity.Publisher;
import ru.testproj.book.backend.mapper.AuthorMapper;
import ru.testproj.book.backend.mapper.BookMapper;
import ru.testproj.book.backend.mapper.PublisherMapper;
import ru.testproj.book.backend.repository.AuthorRepository;
import ru.testproj.book.backend.repository.BookRepository;
import ru.testproj.book.backend.repository.PublisherRepository;
import ru.testproj.book.backend.service.BookService;

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


    //вывод всех книг + пагинация
    @Override
    public PagebleResponse<BookDto> getBookAll(int page, int elements) {
        Pageable pageable = PageRequest.of(page, elements);
        Page<Book> books = bookRepository.getAllBy(pageable);

        PagebleResponse<BookDto> pagebleResponse = PagebleResponse.<BookDto>builder()
                .elements((int) books.getTotalElements())
                .hasMore(books.hasNext())
                .data(books.stream()
                        .map(bookMapper::bookEntityToBookDto)
                        .collect(Collectors.toList()))
                .build();
        return pagebleResponse;

    }

    //поиск по id книги
    @Override
    public BookDto getBookId(UUID id) {
        return bookMapper.bookEntityToBookDto(bookRepository.findBookById(id));
    }

    //поиск книги по названию
    @Override
    public List<BookDto> getBookTitle(String title) {
        return bookRepository.findBookByTitleContainsIgnoreCase(title).stream()
                .map(bookMapper::bookEntityToBookDto)
                .toList();
    }


    //создание книги
//    нужна проверка на дубль автор издание цена
    @Override
    public String createBook(BookDto bookDto) {
        Book newBook = bookMapper.bookDtoToBook(bookDto);
        String author = bookDto.getAuthor().getName();
        String title = bookDto.getPublisher().getTitle();
        String city = bookDto.getPublisher().getCity();
        String titleBook = bookDto.getTitle();
        Book book = bookRepository.getBook(titleBook, city, title, author);
//                проверка автора, если есть подсунуть с БД, иначе новый
        Author newAuthor = (Author) authorRepository.findAuthorByNameContainsIgnoreCase(author)
                .orElse(authorMapper.authorDtoToAuthorEntity(bookDto.getAuthor()));
//        проверка издательства, если есть подсунуть с БД, иначе новый
        Publisher newPublisher = publisherRepository.findPublisherByTitleContainsIgnoreCaseAndCityContainsIgnoreCase(title, city)
                .orElse(publisherMapper.publisherDtoToPublisherEntity(bookDto.getPublisher()));
        newBook.setAuthor(newAuthor);
        newBook.setPublisher(newPublisher);
        if (book == null) {
            log.info("книга создана");
            return bookRepository.save(newBook).getId().toString();
        } else if (newBook.compareTo(book) == 0) {
            log.info("книга уже есть");
            return "Книга есть";
        }
        return "болт";
    }

    //          поиск книги по автору
    @Override
    public List<BookDto> getBookAuthor(String author) {
        try {
            Author author1 = (Author) authorRepository.findAuthorByNameContainsIgnoreCase(author).orElseThrow(() -> new NotFoundException("Автора нет"));
            return author1.getBook().stream()
                    .map(bookMapper::bookEntityToBookDto)
                    .toList();
        } catch (NullPointerException | NotFoundException e) {
            log.info("Автор " + author + " не найден");
            return new Lister.Pack<>(BookDto.class);


        }


    }
}
