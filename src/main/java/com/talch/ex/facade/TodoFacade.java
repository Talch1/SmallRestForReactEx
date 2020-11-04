package com.talch.ex.facade;


import org.springframework.http.ResponseEntity;


public interface TodoFacade {

    ResponseEntity<?> getTodoByUser(String userEmail, String token);
}
