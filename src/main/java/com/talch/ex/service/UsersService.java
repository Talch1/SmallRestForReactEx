package com.talch.ex.service;

import com.talch.ex.beans.Todo;
import com.talch.ex.beans.Users;
import com.talch.ex.facade.UserFacade;
import com.talch.ex.repo.TodoRepo;
import com.talch.ex.repo.UsersRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
@Scope("prototype")
public class UsersService implements UserFacade {

    private final UsersRepo usersRepo;

    private final TodoRepo todoRepo;
    //String initToken = UUID.randomUUID().toString().toUpperCase();
    private static int initTokenForTest = 1;

    @Override
    public Users getUserByEmail(String email) {
        return usersRepo.findByEmail(email).orElse(null);
    }

    @Override
    public Users getUserByToken(String token) {
        return usersRepo.findByToken(token).orElse(null);
    }

    @Override
    public ResponseEntity<?> login(String token, String email, String password) {
        Optional<Users> user = usersRepo.findByToken(token);
        if ((user.isPresent()) && (user.get().getPassword().equals(password)) && (user.get().getEmail().equals(email))) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect email or password");
    }

    @Override
    public ResponseEntity<?> register(Users user) {
        if (usersRepo.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This user is exist");
        } else {
            user.setToken(initTokenForTest + "");
            initTokenForTest++;
            List<Todo> initionalList = new ArrayList<Todo>();
            Todo inutTodo = new Todo(initTokenForTest + "todo", "do first todo", "first todo");
            todoRepo.save(inutTodo);
            initionalList.add(inutTodo);
            user.setTodos(initionalList);
            usersRepo.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
    }
}
