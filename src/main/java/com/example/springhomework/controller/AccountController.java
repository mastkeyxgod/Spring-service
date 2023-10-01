package com.example.springhomework.controller;

import com.example.springhomework.controller.dto.AccountRequestDTO;
import com.example.springhomework.controller.dto.AccountResponseDTO;
import com.example.springhomework.entity.Account;
import com.example.springhomework.entity.Bill;
import com.example.springhomework.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/accounts")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO){
        return accountService.saveAccount(accountRequestDTO.getName(),
                accountRequestDTO.getEmail(),
                accountRequestDTO.getBillList().stream().map(Bill::new).collect(Collectors.toList()));
    }

    @GetMapping("/accounts/{id}")
    public AccountResponseDTO getById(@PathVariable Long id){
        return new AccountResponseDTO(accountService.getAccountById(id));
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
