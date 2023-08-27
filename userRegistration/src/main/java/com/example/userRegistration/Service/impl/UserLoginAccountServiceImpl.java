package com.example.userRegistration.Service.impl;

import com.example.userRegistration.Dto.UserLoginAccountDTO;
import com.example.userRegistration.Entity.UserLoginAccount;
import com.example.userRegistration.Repository.UserLoginAccountRepository;
import com.example.userRegistration.Service.UserLoginAccountService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserLoginAccountServiceImpl implements UserLoginAccountService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserLoginAccountServiceImpl.class);
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserLoginAccountRepository userLoginAccountRepository;

    @Override
    public ResponseEntity<String> saveUserLoginAccount(UserLoginAccountDTO dto) {
        UserLoginAccount userLoginAccount;
        try {
            userLoginAccount = new UserLoginAccount();
            userLoginAccount.setUserName(dto.getUserName());
            userLoginAccount.setPassword(passwordEncoder.encode(dto.getPassword()));
            userLoginAccountRepository.save(userLoginAccount);
        } catch (Exception e) {
            LOGGER.warn("/**************** Exception in UserAccountService -> saveUserAccount()" + e);
        }
        return new ResponseEntity<>("User account saved successfully!!!", HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<String> saveUpdateToken(String token, String userName) {
        try {
            UserLoginAccount userLoginAccount;
            userLoginAccount = userLoginAccountRepository.findByUserName(userName);
            userLoginAccount.setToken(token);
            userLoginAccountRepository.save(userLoginAccount);
        } catch (Exception e) {
            LOGGER.warn("/**************** Exception in UserAccountService -> saveUpdateToken()" + e);
        }
        return new ResponseEntity<>("User token saved successfully!", HttpStatus.CREATED);
    }


    public String getHomePage(String token) {
        UserLoginAccount userLoginAccount = getUserByToken(token);
        String homePage = null;

        if (userLoginAccount == null) {
            homePage = "No Permission to redirect!";
        } else {
            homePage = "This is the User Home Page>> " + userLoginAccount.getUserName();
        }
        return homePage;
    }

    public UserLoginAccount getUserByToken(String token) {
        return userLoginAccountRepository.findByToken(token);
    }

    public UserLoginAccount findAccountById(Long id) {
        return userLoginAccountRepository.findById(id).orElse(null);
    }


}
