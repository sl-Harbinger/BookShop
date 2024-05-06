package ru.testproj.book.backend.mapper;

import org.mapstruct.Mapper;
import ru.testproj.book.backend.api.dto.AuthorDto;
import ru.testproj.book.backend.entity.Author;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author authorDtoToAuthorEntity(AuthorDto authorDto);

    AuthorDto authorEntityToauthorDto(Author author);
}
