package com.talch.ex.service;

import com.talch.ex.beans.Users;
import com.talch.ex.repo.UsersRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
@Scope("prototype")
public class UsersService implements UserFacade {

    private final UsersRepo repo;


    @Override
    public Users getUserById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Users getUserByToken(String token) {
        return repo.findByToken(token).orElse(null);
    }

    @Override
    public ResponseEntity<?> login(String token, String email, String password) {
        Optional<Users> user = repo.findByToken(token);
        if ((user.isPresent()) && (user.get().getPassword().equals(password)) && (user.get().getEmail().equals(email))) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect email or password");
    }

    @Override
    public ResponseEntity<?> register(Users user) {
        if (repo.findByToken(user.getToken()).isPresent() || repo.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This user is exist");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(repo.save(user));
        }
    }
}
