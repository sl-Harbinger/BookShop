package ru.testproj.book.backend.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.api.dto.PagebleResponse;
import ru.testproj.book.backend.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.testproj.book.backend.mapper.BookMapper;
import ru.testproj.book.backend.repository.BookRepository;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagebleResponseImpl {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    public PagebleResponse<BookDto> getPageable(int element, int size) {
    Pageable pageable = PageRequest.of(element, size);
    Page<Book> books = bookRepository.getAllBy(pageable);
    PagebleResponse<BookDto> pagebleResponse = new PagebleResponse<>();
    pagebleResponse.setElements((int) books.getTotalElements());
    pagebleResponse.setHasMore(books.hasNext());
    pagebleResponse.setData(books.stream()
                .map(bookMapper::bookEntityToBookDto)
                .collect(Collectors.toList()));
    return pagebleResponse;
    }
}
