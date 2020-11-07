package com.talch.ex.controller;

import com.talch.ex.beans.Todo;
import com.talch.ex.service.TodoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping
@CrossOrigin("*")
public class TodoController {
    private final TodoService service;

    // http://localhost:8081/todos
    @GetMapping(value = "/todos/")
    public ResponseEntity<?> todos(@RequestHeader String token) {
        return service.getTodoByUser(token);
    }
    // http://localhost:8081/api/users/addtodos
    @PostMapping(value = "/addtodos/")
    public ResponseEntity<?> addtodos(@RequestHeader String token,@RequestBody Todo todo) {
        return service.addTodoToUser(token,todo);
    }
}
