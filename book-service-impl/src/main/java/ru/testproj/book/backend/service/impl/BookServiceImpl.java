package ru.testproj.book.backend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.entity.Book;
import ru.testproj.book.backend.mapper.BookDtoToBookEntityMapper;
import ru.testproj.book.backend.repository.BookRepository;
import ru.testproj.book.backend.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service

public class BookServiceImpl implements BookService {
//инверсия контроля
    private BookRepository bookRepository;
//    private BookDtoToBookEntityMapperImpl bookDtoToBookEntityMapper;
    private final BookDtoToBookEntityMapper mapper;



    public BookServiceImpl(BookRepository bookRepository, BookDtoToBookEntityMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }


//    private BookDto createBookDto (Book book){
//        AuthorDto authorDto = new AuthorDto();
//        Author author1 = book.getAuthor();
//        authorDto.setName(author1.getName());
//        authorDto.setId(author1.getId());
//
//        PublisherDto publisherDto = new PublisherDto();
//        Publisher publisher1 = book.getPublisher();
//        publisherDto.setId(publisher1.getId());
//        publisherDto.setTitle(publisher1.getTitle());
//        publisherDto.setCity(publisher1.getCity());
//
//        BookDto dto = new BookDto();
//        dto.setTitle(book.getTitle());
//        dto.setId(UUID.fromString(book.getId().toString())); //ооп
//        dto.setPrice(book.getPrice());
//        dto.setAuthor(authorDto);
//        dto.setPublisher(publisherDto);
//        return dto;
//    }
//
//    private Book createEntity (BookDto bookDto){
//        Publisher publisher1 = new Publisher();
//        PublisherDto publisherDto = bookDto.getPublisher() ;
//        publisher1.setTitle(publisherDto.getTitle());
//        publisher1.setCity(publisherDto.getCity());
//
//        Author author1 = new Author();
//        AuthorDto authorDto = bookDto.getAuthor();
//        author1.setName(authorDto.getName());
//
//        Book book1 = new Book();
//        book1.setPrice(bookDto.getPrice());
//        book1.setTitle(bookDto.getTitle());
//        book1.setPublisher(publisher1);
//        book1.setAuthor(author1);
//
//        return book1;
//    }


    @Override
    public List<BookDto> getBookAll() {
        List<Book> books = bookRepository.getBookAll();
        List<BookDto> dtos = new ArrayList<>();
//пагинация
        for (Book book:books) {
                dtos.add(mapper.bookEntityToBookDto(book));
        }
        return dtos;
    }


    @Override
    public BookDto getBookId(UUID id) {
        return mapper.bookEntityToBookDto(bookRepository.findBookById(id));
  }


    @Override
    @Transactional
    public String createBook(BookDto bookDto) {
//        поиск автора и замапить if
        BookDto newBookDto = new BookDto();

//        if (bookDto.getPublisher().equals(mapper.publisherDtoToAuthorEntity(bookDto.getPublisher()))) {
//            return bookDto.getPublisher().toString();
//
//        }

        Book book =  mapper.bookDtoToBookEntity(bookDto);
//       Book book =  bookDtoToBookEntityMapper.INSTANCE.bookDtoToBookEntity(bookDto);

        String id = bookRepository.save(book).getId().toString();

        return id;
    }


}
