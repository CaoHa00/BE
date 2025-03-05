package com.example.BE.service;

import java.util.List;

import com.example.BE.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    List<AccountDto> getAllAccounts();

    AccountDto getAccountById(Long accountId);

    AccountDto updateAccount(Long accountId, AccountDto updateAccount);

    void deleteAccount(long accountId);

}
