package com.memorybox.api;

import com.memorybox.domain.corebank.service.CoreBankService;
import com.memorybox.dto.AccountCreateRequestDto;
import com.memorybox.dto.BalanceUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/corebank")
public class CoreBankApi {

    private final CoreBankService coreBankService;

    @PostMapping("/account")
    public ResponseEntity<?> createAccount(@RequestBody AccountCreateRequestDto accountCreateRequestDto){
        return ResponseEntity.ok().body(coreBankService.createAccount(accountCreateRequestDto));
    }

    @PatchMapping("/balance")
    public ResponseEntity<?> depositMoney(@RequestBody BalanceUpdateRequestDto balanceUpdateRequestDto){
        return ResponseEntity.ok().body(coreBankService.updateBalance(balanceUpdateRequestDto));
    }

    @GetMapping("/{coreBankId}/info")
    public ResponseEntity<?> getAccountInfo(@PathVariable Long coreBankId){
        return ResponseEntity.ok().body(coreBankService.getCoreBankInfo(coreBankId));
    }

    @GetMapping("/{coreBankId}/maturity")
    public ResponseEntity<?> getAccountMaturity(@PathVariable Long coreBankId){
        return ResponseEntity.ok().build();
    }
}
