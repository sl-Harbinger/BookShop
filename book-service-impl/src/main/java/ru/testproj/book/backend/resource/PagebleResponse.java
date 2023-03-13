package ru.testproj.book.backend.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.entity.Book;

import java.util.stream.Collectors;

public interface PagebleResponse<T> {
//     static PagebleResponse<T> getPageable(int element, int size) {
//         Pageable pageable = PageRequest.of(element, size);
//
//         PagebleResponse<T> pagebleResponse;
//     }
}
