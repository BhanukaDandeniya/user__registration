package com.example.userRegistration.Service.impl;

import com.example.userRegistration.Dto.PersonDTO;
import com.example.userRegistration.Entity.Person;
import com.example.userRegistration.Entity.UserLoginAccount;
import com.example.userRegistration.Repository.PersonRepository;
import com.example.userRegistration.Service.PersonService;
import com.example.userRegistration.Service.UserLoginAccountService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonServiceImpl implements PersonService {

    private final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserLoginAccountService userLoginAccountService;

    @Transactional
    public ResponseEntity<String> savePerson(@RequestBody PersonDTO dto, String userAccountId) {
        Person person;
        try {
            UserLoginAccount userAccount = userLoginAccountService.findAccountById(Long.parseLong(userAccountId));
            person = new Person();
            person.setFirstName(dto.getFirstName());
            person.setLastName(dto.getLastName());
            person.setAddress(dto.getAddress());
            person.setEmail(dto.getEmail());
            person.setNic(dto.getNic());
            person.setUserAccount(userAccount);
            personRepository.save(person);
        } catch (Exception e) {
            LOGGER.warn("/**************** Exception in PersonService -> savePerson()" + e);
        }
        return new ResponseEntity<>("Person saved successfully!!!", HttpStatus.CREATED);
    }


}
