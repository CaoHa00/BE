package com.example.BE.service;

import java.util.List;

import com.example.BE.dto.PersonDto;

public interface PersonService {
    PersonDto createPerson (PersonDto personDto);

    PersonDto getPersonById(Long personId);
    List<PersonDto> getAllPersons();
    PersonDto updatePerson(Long personId, PersonDto updatePerson);
    void deletePerson(long personId);
}
