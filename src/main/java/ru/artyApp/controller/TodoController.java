package ru.artyApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.artyApp.entity.TodoEntity;
import ru.artyApp.exeption.TodoNotFoundException;
import ru.artyApp.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity create(@RequestBody TodoEntity todo){
        try{
            todoService.create(todo);
            return ResponseEntity.ok("Задача создана");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            return ResponseEntity.ok(todoService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getTodo(@RequestParam Long id) {
        try{
            return ResponseEntity.ok(todoService.getOne(id));
        }catch (TodoNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
