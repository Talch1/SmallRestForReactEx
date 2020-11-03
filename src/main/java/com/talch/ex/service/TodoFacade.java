package com.talch.ex.service;


import org.springframework.http.ResponseEntity;


public interface TodoFacade {

    ResponseEntity<?> getTodoByUser(long userId, String token);
}
