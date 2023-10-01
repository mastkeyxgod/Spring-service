package com.example.springhomework.utils;

import com.example.springhomework.entity.Account;
import com.example.springhomework.entity.Bill;
import com.example.springhomework.exceptions.NotDefaultBillException;

public class AccountUtils {
    public static Bill findDefaultBill(Account accountFrom) {
        return accountFrom.getBillList()
                .stream()
                .filter(Bill::isDefault)
                .findAny()
                .orElseThrow(() ->
                        new NotDefaultBillException("Not found default bill"));
    }
}
