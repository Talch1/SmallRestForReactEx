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

import javax.annotation.PostConstruct;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
@RequiredArgsConstructor
public class UsersService implements UserFacade {

    private final UsersRepo usersRepo;

    private final TodoRepo todoRepo;

    @PostConstruct
    public void init() {
        Todo todo = new Todo("111", "Do it NoW!!!!!!!", "Do it");
        Users user = new Users("Tom", "Fox", "Tom@gimail.com", "123456", "123", null);
        List<Todo> todos = new ArrayList<>();
        todos.add(todo);
        user.setTodos(todos);
        todoRepo.save(todo);
        usersRepo.save(user);
       System.out.println("1:  " + user);
    }

    @Override
    public Users getUserByEmail(String email) {
        return usersRepo.findByEmail(email).orElse(null);
    }

    @Override
    public Users getUserByToken(String token) {
        return usersRepo.findByToken(token).orElse(null);
    }

    @Override
    public ResponseEntity<?> login( String email, String password) {
        Optional<Users> user = usersRepo.findByEmail(email);
        if ((user.isPresent()) && (user.get().getPassword().equals(password))) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get().getToken());
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect email or password");
    }

    @Override
    public ResponseEntity<?> register(Users user) {
        String initToken = UUID.randomUUID().toString().toUpperCase();
        if (usersRepo.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This user is exist");
        } else {
            user.setToken(initToken + "");
            List<Todo> initionalList = new ArrayList<>();
            Todo inutTodo = new Todo(initToken + "todo", "do first todo", "first todo");
            todoRepo.save(inutTodo);
            initionalList.add(inutTodo);
            user.setTodos(initionalList);
            System.out.println(user);
            usersRepo.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
    }
}
