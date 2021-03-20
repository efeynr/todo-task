package com.efeyener.todoapp.dao;

import com.efeyener.todoapp.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoFakeDao {

    Todo createTask(Todo todo);

    List<Todo> selectAll(); //to print the database

    Optional<Todo> selectTaskById(Integer id);  //Optional yerine List kullanmayı düşünebilirsin

    Integer deleteTaskById(Integer id);

    void updateTaskById(Integer id, Todo todo);
}
