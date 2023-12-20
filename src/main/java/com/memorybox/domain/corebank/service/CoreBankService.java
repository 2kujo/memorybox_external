package com.memorybox.domain.corebank.service;

import com.memorybox.domain.corebank.entity.CoreBank;
import com.memorybox.domain.corebank.repository.CoreBankRepository;
import com.memorybox.dto.AccountCreateRequestDto;
import com.memorybox.dto.AccountCreateResponseDto;
import com.memorybox.dto.AccountInfoResponseDto;
import com.memorybox.dto.BalanceUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoreBankService {

    private final CoreBankRepository coreBankRepository;

    public AccountCreateResponseDto createAccount(AccountCreateRequestDto accountCreateRequestDto){
        String accountNum = createAccountNum();
        CoreBank account = coreBankRepository.save(accountCreateRequestDto.toEntity(accountNum, setMaturityDate()));
        return new AccountCreateResponseDto(account);
    }

    @Transactional
    public int updateBalance(BalanceUpdateRequestDto balanceUpdateRequestDto){
        CoreBank coreBank = getCoreBank(balanceUpdateRequestDto.coreBankId());
        return coreBank.updateBalance(balanceUpdateRequestDto.money());
    }

    public AccountInfoResponseDto getCoreBankInfo(long coreBankId){
        log.info(" >>> CoreBankService getCoreBankInfo Call!!!");
        CoreBank coreBank = getCoreBank(coreBankId);
        return new AccountInfoResponseDto(coreBank);
    }

    private CoreBank getCoreBank(long coreBankId){
        return coreBankRepository.findById(coreBankId)
                .orElseThrow(() -> new IllegalArgumentException("해당 계좌가 없습니다. id=" + coreBankId));
    }

    private String createAccountNum(){
        Random random = new Random();

        String accountNum;
        String branchNo = "2170";
        String productType = "24";
        int randomNum = random.nextInt(100000000);
        String serialNum = String.format("%08d", randomNum);

        accountNum = branchNo + productType + serialNum;

        return accountNum;
    }

    private LocalDate setMaturityDate(){
        LocalDate startDate = LocalDate.now();
        int maturityYear = 1;
        return startDate.plusYears(maturityYear);
    }

}
