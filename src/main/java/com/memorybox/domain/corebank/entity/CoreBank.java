package com.memorybox.domain.corebank.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
//@Builder
@NoArgsConstructor
public class CoreBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long coreBankId;

    private String accountNum;

    private int balance;

    private String receivedAccount;

    private String productName;

    private LocalDate startDate;

    private LocalDate maturityDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public CoreBank(Long coreBankId, String accountNum, int balance, String receivedAccount, String productName, LocalDate startDate, LocalDate maturityDate, LocalDateTime createdAt){
        this.coreBankId = coreBankId;
        this.accountNum = accountNum;
        this.balance = balance;
        this.receivedAccount = receivedAccount;
        this.productName = productName;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
        this.createdAt = createdAt;
    }

    public int updateBalance(int money){
        balance += money;
        return balance;
    }
}
