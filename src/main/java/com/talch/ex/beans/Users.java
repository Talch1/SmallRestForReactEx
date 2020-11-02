
package com.talch.ex.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
public class Users {

    @Id
    private long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String token;
}
