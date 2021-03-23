package com.efeyener.todoapp.service;


import com.efeyener.todoapp.dao.TodoDao;
import com.efeyener.todoapp.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private Integer idCounter=1;
    private final TodoDao todoDao;

    @Autowired // we are autowiring into TodoDao interface (injection)

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public Todo addTask(Todo todoTask) {
        todoTask.setStatus(false);
        todoTask.setTaskName("New Task");
        todoTask.setId(idCounter++);
        todoDao.save(todoTask);
        return todoTask;
    }

    public List<Todo> getAllTasks() {
        if(todoDao.findAll().isEmpty()){
            Todo firstTask =new Todo();
            firstTask.setTaskName("New Task");
            firstTask.setId(idCounter++);
            firstTask.setStatus(false);
            todoDao.save(firstTask);
        }
        return todoDao.findAll();
    }


    public void deleteTask(Integer id) {
        todoDao.deleteById(id);
    }

    public Todo updateTask(Integer id, Todo update) {
        Optional<Todo> updatedTask = todoDao.findById(id);
        Todo item = null;
        if (updatedTask.isPresent()) {
            item = updatedTask.get();
            item.setStatus(update.getStatus());
            item.setTaskName(update.getTaskName());
        }
        todoDao.deleteById(id);
        todoDao.save(item);
        return item;
    }

}



