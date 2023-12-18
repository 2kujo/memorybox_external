package com.memorybox.api;

import com.memorybox.domain.corebank.service.CoreBankService;
import com.memorybox.dto.AccountCreateRequestDto;
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
    public ResponseEntity<?> depositMoney(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountNum}/info")
    public ResponseEntity<?> getAccountInfo(@PathVariable String accountNum){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountNum}/maturity")
    public ResponseEntity<?> getAccountMaturity(@PathVariable String accountNum){
        return ResponseEntity.ok().build();
    }
}
