package com.memorybox.dto;

import com.memorybox.domain.corebank.entity.CoreBank;

import java.time.LocalDate;

public record AccountCreateResponseDto(long coreBankId, String accountNum, int balance, String productName, LocalDate startDate, LocalDate maturityDate) {
    public AccountCreateResponseDto(CoreBank entity){
        this(entity.getId(), entity.getAccountNum(), entity.getBalance(), entity.getProductName(), entity.getStartDate(), entity.getMaturityDate());

    }
}
