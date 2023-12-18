package com.memorybox.domain.corebank.service;

import com.memorybox.domain.corebank.repository.CoreBankRepository;
import com.memorybox.dto.AccountCreateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoreBankService {

    private final CoreBankRepository coreBankRepository;


    public String createAccount(AccountCreateRequestDto accountCreateRequestDto){
        String accountNum = createAccountNum();
        coreBankRepository.save(accountCreateRequestDto.toEntity(accountNum));
        return accountNum;
    }


    public String createAccountNum(){
        Random random = new Random();

        String accountNum;
        String branchNo = "2170";
        String productType = "24";
        int randomNum = random.nextInt(100000000);
        String serialNum = String.format("%08d", randomNum);

        accountNum = branchNo + productType + serialNum;

        return accountNum;
    }
}
