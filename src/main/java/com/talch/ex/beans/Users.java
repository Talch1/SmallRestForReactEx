
package com.talch.ex.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "usersTable")
@RequiredArgsConstructor
@AllArgsConstructor
public class Users {

    private String name;

    private String lastName;

    @Id
    private String email;

    private String password;

    private String token;

    @OneToMany
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Todo> todos;
}