package com.example.userRegistration.Service;

import com.example.userRegistration.Dto.UserLoginAccountDTO;
import com.example.userRegistration.Entity.UserLoginAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserLoginAccountService {

    ResponseEntity<String> saveUserLoginAccount(@RequestBody UserLoginAccountDTO dto);

    ResponseEntity<String> saveUpdateToken(String token, String userName);

    String getHomePage(String token);

    UserLoginAccount getUserByToken(String token);

    UserLoginAccount findAccountById(Long id);



}
