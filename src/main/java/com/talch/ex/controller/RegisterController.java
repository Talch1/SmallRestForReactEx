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
@RequestMapping("/api/users")
public class RegisterController {


    private final UsersService service;

    // http://localhost:8081/api/users/register/"
    @PostMapping(value = "/register/")
    public ResponseEntity<?> register(@RequestHeader String token, @RequestBody Users user) {
        return service.register(user);
    }


}
