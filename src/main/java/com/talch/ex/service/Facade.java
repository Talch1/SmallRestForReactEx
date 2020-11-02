package com.talch.ex.service;


import com.talch.ex.beans.Users;
import org.springframework.http.ResponseEntity;

public interface Facade {

    Users getUserById(long id);

    Users getUserByToken(String token);

    ResponseEntity<?> login(String token, String email, String password);

    ResponseEntity<?> register(Users user);

}
