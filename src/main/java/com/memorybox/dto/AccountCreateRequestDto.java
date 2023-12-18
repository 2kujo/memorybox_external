package com.memorybox.dto;

import com.memorybox.domain.corebank.entity.CoreBank;

import java.time.LocalDate;

public record AccountCreateRequestDto(String receivedAccount, String productName, String productType, LocalDate startDate, LocalDate maturityDate){

    public CoreBank toEntity(String accountNum){
        return CoreBank.builder()
                .accountNum(accountNum)
                .receivedAccount(receivedAccount)
                .productName(productName)
                .productType(productType)
                .startDate(startDate)
                .maturityDate(maturityDate)
                .build();
    }
}

