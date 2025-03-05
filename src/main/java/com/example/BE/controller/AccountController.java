package com.example.BE.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BE.dto.AccountDto;
import com.example.BE.service.AccountService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {
    public AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountDto> getAccountById(Long accountId) {
        AccountDto accountDto = accountService.getAccountById(accountId);
        return ResponseEntity.ok(accountDto);
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(AccountDto accountDto) {
        AccountDto savedAccount = accountService.createAccount(accountDto);
        return ResponseEntity.ok(savedAccount);
    }

    @PutMapping("{id}")
    public ResponseEntity<AccountDto> updateAccount(Long accountId, AccountDto updateAccount) {
        AccountDto accountDto = accountService.updateAccount(accountId, updateAccount);
        return ResponseEntity.ok(accountDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(Long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok("Account deleted successfully");
    }

}
