package com.talch.ex.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@RequiredArgsConstructor
@Table(name="todosTable")
public class Todo {


    private String description;

    @Id
    private String title;
}
