package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todoService")
public class TodosServiceimpl implements TodosService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todos markComplete(long todoid){

        Todos currentTodos = todoRepository.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Todo with" + todoid + "Was not found"));
        currentTodos.setCompleted(true);
        return todoRepository.save(currentTodos);   
    }

    @Transactional
    @Override
    public void delete(long todoid) {
        if (todoRepository.findById(todoid)
                .isPresent())
        {
            todoRepository.deleteById(todoid);
        } else
        {
            throw new EntityNotFoundException("Useremail with id " + todoid + " Not Found!");
        }
    }
}
