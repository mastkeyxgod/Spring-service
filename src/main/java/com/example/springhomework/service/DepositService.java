package com.example.springhomework.service;

import com.example.springhomework.entity.Account;
import com.example.springhomework.entity.Bill;
import com.example.springhomework.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DepositService {
    @Autowired
    AccountService accountService;
    public Object deposit(Long accountId, BigDecimal deposit) {
        Account account = accountService.getAccountById(accountId);
        Bill bill = AccountUtils.findDefaultBill(account);
        bill.setAmount(bill.getAmount().add(deposit));
        accountService.update(account);
        return "success";
    }
}
