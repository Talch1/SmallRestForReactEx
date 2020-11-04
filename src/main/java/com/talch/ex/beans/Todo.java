package com.talch.ex.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@RequiredArgsConstructor
@Table(name="todosTable")
@AllArgsConstructor
public class Todo {

    @Id
    private String id;

    private String description;

    private String title;


}
