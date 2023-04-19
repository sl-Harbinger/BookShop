package ru.testproj.book.backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.testproj.book.backend.api.dto.UserDto;
import ru.testproj.book.backend.entity.User;
import ru.testproj.book.backend.service.UserService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/book-service/book/users/")
public class UserRestController {
    private final UserService userService;

    @GetMapping(value = "{id}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") UUID id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
}
