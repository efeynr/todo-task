package com.efeyener.todoapp.service;


import com.efeyener.todoapp.dao.TodoDao;
import com.efeyener.todoapp.dao.TodoFakeDao;
import com.efeyener.todoapp.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class TodoService {
 /*
    private final TodoFakeDao todoDao;

    //@Autowired // we are autowiring into TodoDao interface (inject)

    public TodoService(@Qualifier("fakeDao")  TodoFakeDao todoDao) { //TodoDao türü yap Qualifier'ı değiş
            this.todoDao = todoDao;
    }

    public Todo addTask() {
            Todo todoTask = new Todo();
            todoTask.setStatus(false);
           todoTask = todoDao.createTask(todoTask);
           todoTask.setTaskName("Task #"+todoTask.getId());
           return todoTask;
    }

    public List<Todo> getAllTasks() {
        return todoDao.selectAll();
    }

    public Optional<Todo> getTaskById(Integer id) {
        return todoDao.selectTaskById(id);
    }

    public void deleteTask(Integer id) {
         todoDao.deleteTaskById(id);
    }

    public Todo updateTask(Integer id, Todo update) {
        Optional<Todo> todoOptional= todoDao.selectAll().stream().filter(item->item.getId().equals(id)).findAny();

        if(todoOptional.isPresent()){
            Todo item = todoOptional.get();
            item.setStatus(update.getStatus());
            item.setTaskName(update.getTaskName());
            return item;
        }
        return null;
    }
*/
}



