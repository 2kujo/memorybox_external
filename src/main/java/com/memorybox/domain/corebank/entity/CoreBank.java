package com.memorybox.domain.corebank.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class CoreBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long userId;

    private String accountNum;

    private int balance;

    private String productName;

    @CreationTimestamp
    private LocalDate startDate;

    private LocalDate maturityDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private boolean maturityEnabled;

    @Builder
    public CoreBank(String accountNum, int balance, String productName, LocalDate startDate, LocalDate maturityDate,
                    LocalDateTime createdAt, long userId, boolean maturityEnabled){
        this.userId = userId;
        this.accountNum = accountNum;
        this.balance = balance;
        this.productName = productName;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
        this.createdAt = createdAt;
        this.maturityEnabled = maturityEnabled;
    }

    public int updateBalance(int money){
        balance += money;
        return balance;
    }
}
