package com.memorybox.dto;

import com.memorybox.domain.corebank.entity.CoreBank;

import java.time.LocalDate;

public record AccountCreateResponseDto(Long coreBankId, String accountName, int balance, String productName, LocalDate startDate, LocalDate maturityDate) {
    public AccountCreateResponseDto(CoreBank entity){
        this(entity.getCoreBankId(), entity.getAccountNum(), entity.getBalance(), entity.getProductName(), entity.getStartDate(), entity.getMaturityDate());

    }
}
