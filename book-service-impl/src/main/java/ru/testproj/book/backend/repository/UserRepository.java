package ru.testproj.book.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testproj.book.backend.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
     User findByLogin(String login);


}
