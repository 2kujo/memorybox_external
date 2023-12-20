package com.memorybox.dto;

import com.memorybox.domain.corebank.entity.CoreBank;

import java.time.LocalDate;

public record AccountCreateRequestDto(long userId, String productName){

    public CoreBank toEntity(String accountNum, LocalDate maturityDate){
        return CoreBank.builder()
                .userId(userId)
                .accountNum(accountNum)
                .productName(productName)
                .maturityDate(maturityDate)
                .build();
    }
}

