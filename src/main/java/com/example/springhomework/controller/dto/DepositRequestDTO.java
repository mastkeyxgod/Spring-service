package com.example.springhomework.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class DepositRequestDTO {
    @JsonProperty("account_id")
    private Long account_id;
    @JsonProperty("deposit")
    private BigDecimal deposit;

    public Long getAccount_id() {
        return account_id;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }
}
