package ru.testproj.book.backend.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
public class OrderDto {

    private UUID id;
    private SellerDto sellerDto;
    private CustomerDto customerDto;
    private BookDto bookDto;
    private Date data;
    private Integer number;
}
