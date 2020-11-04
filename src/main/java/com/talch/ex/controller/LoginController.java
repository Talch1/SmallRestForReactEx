package com.talch.ex.controller;


import com.talch.ex.service.UsersService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping
public class LoginController {

    private final UsersService service;

    // http://localhost:8081/api/users/login/"
    @PostMapping(value = "/login/")
    public ResponseEntity<?> login(@RequestHeader String token, @RequestParam String email, @RequestParam String password) {
        return service.login(token, email, password);
    }
}
