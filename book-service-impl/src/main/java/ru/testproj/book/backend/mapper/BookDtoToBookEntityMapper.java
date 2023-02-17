package ru.testproj.book.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.testproj.book.backend.api.dto.AuthorDto;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.api.dto.PublisherDto;
import ru.testproj.book.backend.entity.Author;
import ru.testproj.book.backend.entity.Book;
import ru.testproj.book.backend.entity.Publisher;

@Mapper(componentModel = "spring")
public interface BookDtoToBookEntityMapper {

//    BookDtoToBookEntityMapper INSTANCE = Mappers.getMapper(BookDtoToBookEntityMapper.class);

    Book bookDtoToBookEntity(BookDto bookDto);
    BookDto bookEntityToBookDto(Book book);


    Author authorDtoToAuthorEntity(AuthorDto authorDto);
    AuthorDto authorEntityToauthorDto(Author author);

    Publisher publisherDtoToAuthorEntity(PublisherDto publisherDto);
    PublisherDto publisherEntityToPublisherDto(Publisher publisher);


}
