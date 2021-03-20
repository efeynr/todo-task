package com.efeyener.todoapp.dao;

import com.efeyener.todoapp.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository("fakeDao")
public class FakeTodoDataAccessService implements TodoFakeDao{
    private static List<Todo> DB = new ArrayList<>(); // fake bir database
    private Integer idCounter=0; // for the fake database. We dont need this in real-time database

    @Override
    public Todo createTask(Todo todo) { //save the item
        todo.setId(idCounter++);
        DB.add(todo);
        return todo;
    }

    @Override
    public List<Todo> selectAll() {
        if(DB.size()==0){
            Todo task = new Todo();
            task.setId(idCounter++);
            task.setTaskName("Task #1");
            task.setStatus(false);
            DB.add(task);
        }
        return DB;
    }

    @Override
    public Optional<Todo> selectTaskById(Integer id) {
        return DB.stream().filter(todo -> todo.getId().equals(id)).findFirst(); //stream ile filter yapıp listeyi geziyor
    }

    @Override
    public Integer deleteTaskById(Integer id) {
        Optional<Todo> todo1 = selectTaskById(id);
        if(!todo1.isPresent()) {
            return 0;
        }
            DB.remove(todo1.get());
        return 1;
    }

    @Override
    public void updateTaskById(Integer id, Todo update) {

    }
}
