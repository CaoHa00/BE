package com.example.BE.mapper;

import com.example.BE.dto.PersonDto;
import com.example.BE.entity.Person;

public class PersonMapper {
    public static PersonDto mapToPersonDto( Person person) {
        return new PersonDto(
            person.getId(), 
            person.getName(), 
            person.getAddress(), 
            person.getDob(),
            person.getPhone()
           
            );
    }

    public static Person mapToPerson(PersonDto personDto) {
        return new Person(
           personDto.getId(),
           personDto.getName(),
           personDto.getAddress(),
           personDto.getDob(),
           personDto.getPhone()
           
        );
    }
}
