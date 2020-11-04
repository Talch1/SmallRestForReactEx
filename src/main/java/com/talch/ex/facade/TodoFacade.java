package com.talch.ex.facade;


import com.talch.ex.beans.Todo;
import org.springframework.http.ResponseEntity;


public interface TodoFacade {

    ResponseEntity<?> getTodoByUser(String token);
    ResponseEntity<?> addTodoToUser(String token, Todo todo);
}
