package com.talch.ex.facade;


import com.talch.ex.beans.Users;
import org.springframework.http.ResponseEntity;

public interface UserFacade {

    Users getUserByEmail(String email);

    Users getUserByToken(String token);

    ResponseEntity<?> login(String token, String email, String password);

    ResponseEntity<?> register(Users user);

}
