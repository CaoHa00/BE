package com.example.BE.dto;

import java.util.List;

import com.example.BE.entity.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long id;
    private String name;
    private String address;
    private String dob;
    private String phone;
    private Account account;
}
