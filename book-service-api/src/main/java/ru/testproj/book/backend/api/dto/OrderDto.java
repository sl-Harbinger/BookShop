package ru.testproj.book.backend.api.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class OrderDto {

    private UUID id;
    private SellerDto seller;
    private CustomerDto customer;
    private BookDto book;
    private Date data;
    private Integer number;
}
