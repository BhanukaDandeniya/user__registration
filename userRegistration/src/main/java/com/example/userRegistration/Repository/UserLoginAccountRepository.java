package com.example.userRegistration.Repository;

import com.example.userRegistration.Entity.UserLoginAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginAccountRepository extends JpaRepository<UserLoginAccount, Long> {

////    @Query("SELECT u FROM UserAccount u WHERE u.userName=?1")
//    UserLoginAccount findByUserName(String username);
//
////    @Query("SELECT u FROM UserAccount u WHERE u.token =?1")
//    UserLoginAccount findAccountByToken(String token);
//
////    @Query("SELECT u FROM UserAccount u WHERE u.id=?1")
//    UserLoginAccount findAccountById(Long id);

    UserLoginAccount findByUserName(String userName);

    UserLoginAccount findByToken(String token);
    //UserLoginAccount findById(Long id);




}
