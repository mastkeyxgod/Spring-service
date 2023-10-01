package com.example.springhomework.service;

import com.example.springhomework.entity.Account;
import com.example.springhomework.entity.Bill;
import com.example.springhomework.exceptions.AccountNotFoundException;
import com.example.springhomework.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepo accountRepo;
    public Long saveAccount(String name, String email, List<Bill> billList) {
        Account account = new Account(name, email, billList);
        return accountRepo.save(account).getId();
    }

    public Account getAccountById(Long id) {
        return accountRepo.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(String.format("Account with ID %s not found", id)));
    }

    public Account update(Account account) {
        return accountRepo.save(account);
    }
    public void deleteAccount(Long id) {
        accountRepo.deleteById(id);
    }


}
