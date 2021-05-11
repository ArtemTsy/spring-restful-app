package ru.artyApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.artyApp.entity.TodoEntity;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntity, Long> {

}
