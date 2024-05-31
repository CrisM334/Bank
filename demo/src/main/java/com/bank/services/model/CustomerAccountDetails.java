package com.bank.services.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerAccountDetails {
    private Long customerId;
    private String customerName;
    private String customerEmail;
    private Long accountId;
    private Double accountBalance;
}

