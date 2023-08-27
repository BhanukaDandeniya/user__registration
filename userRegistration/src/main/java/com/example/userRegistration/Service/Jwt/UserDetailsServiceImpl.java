package com.example.userRegistration.Service.Jwt;

import com.example.userRegistration.Entity.UserLoginAccount;
import com.example.userRegistration.Repository.UserLoginAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserLoginAccountRepository userLoginAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLoginAccount userLoginAccount = userLoginAccountRepository.findByUserName(username);
        if (userLoginAccount == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(userLoginAccount.getUserName(), userLoginAccount.getPassword(), new ArrayList<>());
    }

}
