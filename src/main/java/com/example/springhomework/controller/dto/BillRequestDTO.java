package com.example.springhomework.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BillRequestDTO {
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("isDefault")
    private boolean isDefault;

    public BigDecimal getAmount() {
        return amount;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
