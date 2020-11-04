package com.talch.ex.service;

import com.talch.ex.beans.Users;
import com.talch.ex.facade.TodoFacade;
import com.talch.ex.repo.UsersRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Data
@RequiredArgsConstructor
@Service
@Scope("prototype")
public class TodoService implements TodoFacade {

    private final UsersRepo usersRepo;

    @Override
    public ResponseEntity<?> getTodoByUser(String userEmail, String token) {
        Optional<Users> user = usersRepo.findByEmail(userEmail);
        if (user.isPresent() && user.get().getToken().equals(token)) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get().getTodos());
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something wrong...");
    }
}
