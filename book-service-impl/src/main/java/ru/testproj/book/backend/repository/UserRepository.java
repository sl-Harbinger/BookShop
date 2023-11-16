package ru.testproj.book.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testproj.book.backend.entity.User;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
     Optional<User> findByLogin(String login);

}
