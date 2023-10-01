package com.example.springhomework.controller.dto;

import com.example.springhomework.entity.Account;
import com.example.springhomework.entity.Bill;

import java.util.List;
import java.util.stream.Collectors;

public class AccountResponseDTO {
    private Long accountId;

    private String name;

    private String email;

    private List<BillResponseDTO> billList;

    public AccountResponseDTO(Long accountId, String name, String email, List<BillResponseDTO> billList) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.billList = billList;
    }

    public AccountResponseDTO(Account account) {
        this.accountId = account.getId();
        this.name = account.getName();
        this.email = account.getEmail();
        this.billList = account
                .getBillList()
                .stream()
                .map(BillResponseDTO::new)
                .collect(Collectors.toList());
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BillResponseDTO> getBillList() {
        return billList;
    }

    public void setBillList(List<BillResponseDTO> billList) {
        this.billList = billList;
    }
}
