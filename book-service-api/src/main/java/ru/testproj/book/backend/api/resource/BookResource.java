package ru.testproj.book.backend.api.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ru.testproj.book.backend.api.dto.BookDto;

import java.util.List;
import java.util.UUID;

@Tags(
        value = {
                @Tag(name = "Пример ресурса", description = "Пример описания ресурса")
        }
)
public interface BookResource {

    @Operation(summary = "получение всех книг")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "книги получены",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class)) }),
            @ApiResponse(responseCode = "500", description = "счто то пошло не так",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "не найдено",
                    content = @Content) })
    ResponseEntity<List<BookDto>> getBookAll();

//    @GetMapping("/id")
//    BookDto getBookId(UUID id);

//    @GetMapping("/id")
//    ResponseEntity<List<BookDto>> getBookId();


//    @Operation(summary = "получение книги по Id")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "книга получена",
//                    content = { @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = BookDto.class)) }),
//            @ApiResponse(responseCode = "500", description = "счто то пошло не так",
//                    content = @Content),
//            @ApiResponse(responseCode = "404", description = "не найдено",
//                    content = @Content) })
//    ResponseEntity<List<BookDto>> getBookId();


}