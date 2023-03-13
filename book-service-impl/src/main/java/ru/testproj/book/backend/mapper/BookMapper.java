package ru.testproj.book.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book bookDtoToBookEntity(BookDto bookDto);
    BookDto bookEntityToBookDto(Book book);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    Book bookDtoToBook(BookDto bookDto);

}
