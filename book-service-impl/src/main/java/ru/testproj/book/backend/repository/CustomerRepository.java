package ru.testproj.book.backend.repository;

import org.springframework.data.repository.CrudRepository;
import ru.testproj.book.backend.entity.Customer;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

}
