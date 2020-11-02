package com.talch.ex.service;

import com.talch.ex.beans.Users;
import com.talch.ex.repo.UsersRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
@Scope("prototype")
public class UsersService implements Facade {

    private final UsersRepo repo;


    @Override
    public Users getUserById(long id) {
        return repo.findById(id).get();
    }

    @Override
    public Users getUserByToken(String token) {
        return repo.findByToken(token).get();
    }
}
