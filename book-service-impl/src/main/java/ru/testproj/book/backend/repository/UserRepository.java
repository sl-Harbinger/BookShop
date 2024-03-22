package ru.testproj.book.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.testproj.book.backend.entity.User;

import java.util.Optional;
import java.util.UUID;

@Repository

public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findByUsername(String login);

}
