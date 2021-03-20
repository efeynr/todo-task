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


@RequestMapping(value="/api/todo")
@RestController
@CrossOrigin(origins="http://localhost:3000")

public class TodoController {

        private TodoDao todoDao;

        @Autowired // toDoService için ( service <---> controller)
        public TodoController( TodoDao todoDao) {
            this.todoDao = todoDao;
        }
        //@ResponseStatus(HTTPStatus.CREATED)
        @RequestMapping(value="",method=RequestMethod.POST)
            public ResponseEntity<?> addTask(@RequestBody Todo todo) {
            todo.setId((int) (Math.random()*200));
            todo.setTaskName("New Task");
            todo.setStatus(false);
            todoDao.save(todo);
            return ResponseEntity.ok(todo);
        }

          @RequestMapping(value="", method=RequestMethod.GET)
        public ResponseEntity<?> getAllTasks() {
            List<Todo> todoTasks = todoDao.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(todoTasks);// is equal to: ResponseEntity.ok(todoTasks);
        }
    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteTaskById(@PathVariable("id") Integer id) {
        todoDao.deleteById(id);
        return ResponseEntity.ok("200"); //response'da sıkıntı çıkabilir çıkarsa response'ı ignorela(react)
    }
    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateTaskById(@PathVariable("id") Integer id,@RequestBody Todo todo){ //@Valid ekleyebilirsin
        Optional<Todo> updatedTask =todoDao.findById(id);
        Todo item = null;
            if(updatedTask.isPresent()){
                 item= updatedTask.get();
                item.setStatus(todo.getStatus());
                item.setTaskName(todo.getTaskName());
            }
            todoDao.deleteById(id);
            todoDao.save(item);
        return ResponseEntity.ok(item);

    }
/*
     @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteTaskById(@PathVariable("id") Integer id) {
        to.deleteTask(id);
        return ResponseEntity.ok("200"); //response'da sıkıntı çıkabilir çıkarsa response'ı ignorela(react)
    }
         @RequestMapping(value="{id}", method=RequestMethod.PUT)
        public ResponseEntity<?> updateTaskById(@PathVariable("id") Integer id,@RequestBody Todo todo){ //@Valid ekleyebilirsin
                Todo updatedTask =todoService.updateTask(id,todo);
                return ResponseEntity.ok(updatedTask);

        }
        */

}
