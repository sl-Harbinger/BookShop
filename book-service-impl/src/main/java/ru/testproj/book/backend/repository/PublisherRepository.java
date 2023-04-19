package ru.testproj.book.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.testproj.book.backend.entity.Publisher;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, UUID> {

    Optional<Publisher> findPublisherByTitleContainsIgnoreCaseAndCityContainsIgnoreCase(@Param("title") String title, @Param("city") String city);

}
