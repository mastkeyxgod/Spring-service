package com.example.springhomework.service;

import com.example.springhomework.entity.Account;
import com.example.springhomework.entity.Bill;
import com.example.springhomework.exceptions.AccountNotFoundException;
import com.example.springhomework.exceptions.NotDefaultBillException;
import com.example.springhomework.repositories.AccountRepo;
import com.example.springhomework.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {
    @Autowired
     AccountService accountService;
    @Autowired
    AccountRepo accountRepo;
    public Object transfer(Long accountIdFrom, Long accountIdTo, BigDecimal amount) {
        Account accountFrom = accountService.getAccountById(accountIdFrom);
        Account accountTo = accountService.getAccountById(accountIdTo);

        Bill accountFromBill = AccountUtils.findDefaultBill(accountFrom);

        Bill accountToBill = AccountUtils.findDefaultBill(accountTo);

        accountFromBill.setAmount(accountFromBill.getAmount().subtract(amount));
        accountToBill.setAmount(accountToBill.getAmount().add(amount));

        accountService.update(accountFrom);
        accountService.update(accountTo);
        return "success";

    }

}
