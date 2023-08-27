package com.example.userRegistration.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_account")
public class UserLoginAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;

    @Column(name = "password", length = 128)
    private String password;

    @Column(name = "token")
    private String token;

    @OneToOne(mappedBy = "userAccount")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
