package com.example.BE.mapper;

import com.example.BE.dto.AccountDto;
import com.example.BE.entity.Account;

public class AccountMapper {
    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getUsername(),
                account.getPassword());

    }

    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getUsername(),
                accountDto.getPassword());
    }

}
