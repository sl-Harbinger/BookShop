package ru.testproj.book.backend.api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PagebleResponse {
    int size;
    boolean hasMore;
    List<BookDto> data;

}
