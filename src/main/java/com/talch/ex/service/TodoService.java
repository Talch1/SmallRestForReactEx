package com.talch.ex.service;

import com.talch.ex.beans.Todo;
import com.talch.ex.beans.Users;
import com.talch.ex.facade.TodoFacade;
import com.talch.ex.repo.TodoRepo;
import com.talch.ex.repo.UsersRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@Service
@Scope("prototype")
public class TodoService implements TodoFacade {

    private final UsersRepo usersRepo;
    private final TodoRepo todoRepo;

    @Override
    public ResponseEntity<?> getTodoByUser(String token) {
        Optional<Users> user = usersRepo.findByToken(token);

        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get().getTodos());
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something wrong...");

    }

    @Override
    public ResponseEntity<?> addTodoToUser(String token, Todo todo) {
        Optional<Users> user = usersRepo.findByToken(token);
        if (user.isPresent()) {
            todoRepo.save(todo);
            List<Todo> todos = user.get().getTodos();
            todos.add(todo);
            user.get().setTodos(todos);
            usersRepo.save(user.get());

            return ResponseEntity.status(HttpStatus.OK).body(user.get().getTodos());
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something wrong...");
    }
}
