package com.talch.ex.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
public class Todo {


    private String descriprion;
    @Id
    private String title;
}
