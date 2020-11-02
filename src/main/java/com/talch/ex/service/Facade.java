package com.talch.ex.service;


import com.talch.ex.beans.Users;

public interface Facade {

    Users getUserById(long id);

    Users getUserByToken(String token);


}
