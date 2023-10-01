package com.example.springhomework.controller;

import com.example.springhomework.controller.dto.TransferRequestDTO;
import com.example.springhomework.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    TransferService transferService;

    @PostMapping("/transfer")
    public Object transfers(@RequestBody TransferRequestDTO transferRequestDTO){
        return transferService.transfer(transferRequestDTO.getAccountIdFrom(),
                transferRequestDTO.getAccountIdTo(), transferRequestDTO.getAmount());
    }
}
