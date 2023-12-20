package com.memorybox.dto;

import com.memorybox.domain.corebank.entity.CoreBank;

import java.time.LocalDate;

public record AccountCreateRequestDto(String receivedAccount, String productName){

    public CoreBank toEntity(String accountNum, LocalDate maturityDate){
        return CoreBank.builder()
                .accountNum(accountNum)
                .receivedAccount(receivedAccount)
                .productName(productName)
                .maturityDate(maturityDate)
                .build();
    }
}

