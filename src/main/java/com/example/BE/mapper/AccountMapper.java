package com.example.BE.mapper;

import com.example.BE.dto.AccountDto;
import com.example.BE.entity.Account;

public class AccountMapper {
    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getPerson(),
                account.getUsername(),
                account.getPassword());

    }

    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getPerson(),
                accountDto.getUsername(),
                accountDto.getPassword());
    }

}
