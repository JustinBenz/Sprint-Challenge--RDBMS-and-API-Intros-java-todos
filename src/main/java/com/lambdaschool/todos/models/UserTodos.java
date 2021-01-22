package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Table(name = "usertodos")
public class UserTodos extends Auditable implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "todoid")
    @JsonIgnoreProperties(value = "todos", allowSetters = true)
    private Todos todos;
}
