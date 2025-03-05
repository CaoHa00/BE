package com.example.BE.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.BE.dto.PersonDto;
import com.example.BE.entity.Person;
import com.example.BE.exception.ResourceNotFoundException;
import com.example.BE.mapper.PersonMapper;
import com.example.BE.repository.personRepository;
import com.example.BE.service.PersonService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService{
    private personRepository personRepository;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = PersonMapper.mapToPerson(personDto);
        Person savedPerson = personRepository.save(person);
        return PersonMapper.mapToPersonDto(savedPerson);
    }

    @Override
    public PersonDto getPersonById(Long personId) {
        Person person = personRepository.findById(personId).
            orElseThrow(() -> new ResourceNotFoundException("Person is not exist with given id:" +personId));
        return PersonMapper.mapToPersonDto(person);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream().map((person) -> PersonMapper.mapToPersonDto(person)).collect(Collectors.toList()) ;       
    }

    @Override
    public PersonDto updatePerson(Long personId, PersonDto updatePerson) {
        Person person = personRepository.findById(personId).
        orElseThrow(() -> new ResourceNotFoundException("Person is not exist with given id:" +personId));
        person.setName(updatePerson.getName());
        person.setAddress(updatePerson.getAddress());
        person.setDob(updatePerson.getDob());
        person.setPhone(updatePerson.getPhone());
        Person updatePersonObj = personRepository.save(person);
        
        return PersonMapper.mapToPersonDto(updatePersonObj);
    }

    @Override
    public void deletePerson(long personId) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with give id " + personId));
		personRepository.deleteById(personId);
    }
    
}
