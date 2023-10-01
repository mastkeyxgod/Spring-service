package com.example.springhomework.entity;

import com.example.springhomework.controller.dto.BillRequestDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;
    private BigDecimal amount;
    private boolean isDefault;

    public Bill(BigDecimal amount, boolean isDefault) {
        this.amount = amount;
        this.isDefault = isDefault;
    }

    public Bill(BillRequestDTO billRequestDTO) {
        this.amount = billRequestDTO.getAmount();
        this.isDefault = billRequestDTO.isDefault();
    }

    public Bill() {
    }

    public Long getBillId() {
        return billId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
