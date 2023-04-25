package ru.testproj.book.backend.api.dto;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
=======
import lombok.Data;

@Data
>>>>>>> 4bf4add (28.03 секьюрити API KEY Authorization и токен указать)
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
