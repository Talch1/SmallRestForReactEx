
package com.talch.ex.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String token;

    @OneToMany
    private List<Todo> todos;
}