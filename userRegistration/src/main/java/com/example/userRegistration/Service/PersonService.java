package com.example.userRegistration.Service;

import com.example.userRegistration.Dto.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface PersonService {
    ResponseEntity<String> savePerson(@RequestBody PersonDTO dto, String userAccountId);
}
