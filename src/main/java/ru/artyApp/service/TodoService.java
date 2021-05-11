package ru.artyApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artyApp.entity.TodoEntity;
import ru.artyApp.exeption.TodoNotFoundException;
import ru.artyApp.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public TodoEntity create(TodoEntity todo){
        return todoRepository.save(todo);
    }

    public Long delete(Long id){
        todoRepository.deleteById(id);
        return id;
    }

    public TodoEntity getOne(Long id) throws TodoNotFoundException {
        TodoEntity todo = todoRepository.findById(id).get();
        if(todo == null){
            throw new TodoNotFoundException("Задача не найдена");
        }
        return todo;
    }
}
