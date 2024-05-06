package ru.testproj.book.backend.api.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import ru.testproj.book.backend.api.dto.BookDto;
import ru.testproj.book.backend.api.dto.PagebleResponse;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class))}),
            @ApiResponse(responseCode = "500", description = "что то пошло не так",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "не найдено",
                    content = @Content)})
    ResponseEntity<PagebleResponse<BookDto>> getBookAll(@RequestParam(value = "page", defaultValue = "0") @Min(0) int page,
                                                        @RequestParam(value = "size", defaultValue = "10") @Min(1) @Max(100) int size);


    @Operation(summary = "получение книги по Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "книга получена",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class))}),
            @ApiResponse(responseCode = "500", description = "что то пошло не так",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "не найдено",
                    content = @Content)})
    ResponseEntity<BookDto> getBookId(UUID id);


    @Operation(summary = "получение книги по названию")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "книга найдена",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class))}),
            @ApiResponse(responseCode = "500", description = "что то пошло не так",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "не найдено",
                    content = @Content)})
    ResponseEntity<List<BookDto>> getBookTitle(String title);


    @Operation(summary = "добавление книги")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "книга добавлена",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class))}),
            @ApiResponse(responseCode = "500", description = "что то пошло не так",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "не найдено",
                    content = @Content)})
    ResponseEntity<String> createBook(BookDto bookDto);


    @Operation(summary = "поиск книг по автору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "автор найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class))}),
            @ApiResponse(responseCode = "500", description = "что то пошло не так",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "не найдено",
                    content = @Content)})
    ResponseEntity<String> getBookAuthor(String string);

}