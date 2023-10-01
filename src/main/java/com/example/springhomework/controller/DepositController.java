package com.example.springhomework.controller;

import com.example.springhomework.controller.dto.DepositRequestDTO;
import com.example.springhomework.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {
    @Autowired
    DepositService depositService;

    @PostMapping("deposits")
    public Object deposit(@RequestBody DepositRequestDTO depositRequestDTO) {
        return depositService.deposit(depositRequestDTO.getAccount_id(), depositRequestDTO.getDeposit());
    }

}
