package com.example.BE.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BE.dto.AccountDto;
import com.example.BE.dto.PersonDto;
import com.example.BE.service.PersonService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private PersonService personService;

    // build add person REST API

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        PersonDto savedPerson = personService.createPerson(personDto);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    // build Get person REST API
    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable("id") Long personId) {
        PersonDto personDto = personService.getPersonById(personId);
        return ResponseEntity.ok(personDto);
    }

    // build get all persons REST API
    @GetMapping()
    public ResponseEntity<List<PersonDto>> getAllPersons() {
        List<PersonDto> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    // build UpdatePerson REST API
    @PutMapping("{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable("id") long personId,
            @RequestBody PersonDto updatePerson) {
        PersonDto personDto = personService.updatePerson(personId, updatePerson);
        return ResponseEntity.ok(personDto);
    }

    // build Delete person REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Long personId) {
        personService.deletePerson(personId);
        return ResponseEntity.ok("Person have deleted successfully");
    }
}
