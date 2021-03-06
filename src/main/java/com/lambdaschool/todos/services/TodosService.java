package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;

public interface TodosService
{
    Todos markComplete(Todos updatedTodos, long todoid);

    void delete(long todoid);
}
