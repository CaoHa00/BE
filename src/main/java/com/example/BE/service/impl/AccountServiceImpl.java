package com.example.BE.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.BE.dto.AccountDto;
import com.example.BE.entity.Account;
import com.example.BE.mapper.AccountMapper;
import com.example.BE.repository.AccountRepository;
import com.example.BE.service.AccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account is not exist with given id:" + accountId));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto updateAccount(Long accountId, AccountDto updateAccount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account is not exist with given id:" + accountId));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public void deleteAccount(long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account is not exist with given id:" + accountId));
        accountRepository.deleteById(accountId);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

    }
}
