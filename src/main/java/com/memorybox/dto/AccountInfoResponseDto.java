package com.memorybox.dto;

import com.memorybox.domain.corebank.entity.CoreBank;

import java.time.LocalDate;

public record AccountInfoResponseDto(String accountNum, int balance, String receivedAccount, String productName, LocalDate startDate, LocalDate maturityDate) {
    public AccountInfoResponseDto(CoreBank entity) {
        this(entity.getAccountNum(), entity.getBalance(), entity.getReceivedAccount(), entity.getProductName(), entity.getStartDate(), entity.getMaturityDate());
    }
}
