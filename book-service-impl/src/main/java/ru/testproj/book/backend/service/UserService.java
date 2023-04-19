package ru.testproj.book.backend.service;

import ru.testproj.book.backend.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User register(User user);
    List<User> getAll();
    User findByUsername(String username);
    User findById(UUID id);

    void  delete(UUID id);
}
