package com.example.springhomework.controller.dto;

import java.util.List;

public class AccountRequestDTO {
    private String name;
    private String email;
    private List<BillRequestDTO> billList;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<BillRequestDTO> getBillList() {
        return billList;
    }
}
