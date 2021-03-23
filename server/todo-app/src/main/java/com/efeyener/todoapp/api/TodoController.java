package com.efeyener.todoapp.api;


import com.efeyener.todoapp.dao.TodoDao;
import com.efeyener.todoapp.model.Todo;
import com.efeyener.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequestMapping(value = "/api/todo")
@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class TodoController {

    private TodoService todoService;

    @Autowired // autowiring toDoService  ( service <---> controller)
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //@ResponseStatus(HTTPStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> addTask(@RequestBody Todo todo) {
        Todo todo1 = todoService.addTask(todo);
        return ResponseEntity.ok(todo1);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTasks() {
        List<Todo> todoTasks = todoService.getAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(todoTasks);// is equal to: ResponseEntity.ok(todoTasks);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTaskById(@PathVariable("id") Integer id) {
        todoService.deleteTask(id);
        return ResponseEntity.ok("200"); //response'da sıkıntı çıkabilir çıkarsa response'ı ignorela(react)
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTaskById(@PathVariable("id") Integer id, @RequestBody Todo todo) { //@Valid ekleyebilirsin
        Todo item = todoService.updateTask(id, todo);
        return ResponseEntity.ok(item);

    }
}
