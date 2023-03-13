package ru.testproj.book.backend.mapper;

import org.mapstruct.Mapper;
import ru.testproj.book.backend.api.dto.PublisherDto;
import ru.testproj.book.backend.entity.Author;
import ru.testproj.book.backend.entity.Publisher;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    Publisher publisherDtoToPublisherEntity(PublisherDto publisherDto);
    PublisherDto publisherEntityToPublisherDto(Publisher publisher);

}
