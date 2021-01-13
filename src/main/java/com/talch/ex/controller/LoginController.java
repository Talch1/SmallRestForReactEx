package com.talch.ex.controller;


import com.talch.ex.beans.Users;
import com.talch.ex.service.UsersService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping
@CrossOrigin(maxAge = 3600)
public class LoginController {

    private final UsersService service;

    // http://localhost:8081/login/"
    @PostMapping(value = "/login/")
    public ResponseEntity<?> login(@RequestBody Users user) {
        return service.login(user.getEmail(), user.getPassword());
    }
}
