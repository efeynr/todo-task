package com.efeyener.todoapp.service;

import com.efeyener.todoapp.dao.TodoDao;
import com.efeyener.todoapp.model.Todo;
import com.efeyener.todoapp.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class TodoServiceTest {
    @InjectMocks
    private TodoService todoService;
    @Mock
    private TodoDao todoDao;

    //Still on progress!!!
    @Test
    public void testAddTask() {
        Todo todoTest = new Todo();
        todoTest.setTaskName("test-name");
        todoTest.setStatus(true);
        todoTest.setId(1);
        Todo todoMock= mock(Todo.class);
        when(todoDao.save(ArgumentMatchers.any(Todo.class))).thenReturn(todoMock);
        Todo check = todoService.addTask(todoTest);

        Assertions.assertEquals(check.getTaskName(),todoTest.getTaskName());
        Assertions.assertEquals(check.getId(),1);

    }
    @Test
    public void testGetAllTasks() {
        Todo todoTest = new Todo();
        todoTest.setTaskName("test-name");
        todoTest.setStatus(true);
        todoTest.setId(1);

        when(todoDao.findAll()).thenReturn(Collections.singletonList(todoTest));
        List<Todo> todoList =todoService.getAllTasks();
        Assertions.assertEquals(1,todoList.size());
        Assertions.assertEquals(todoList.get(0),Todo.builder().id(1).build()); //we need to check the id of the node in the list(first index)
    }

    @Test
    public void testGetAllTasksWithNoData() {
        Todo todoTest = new Todo();
        todoTest.setTaskName("New Task");
        todoTest.setStatus(false);
        todoTest.setId(1); //We are idCounter is initially 1.(We are doing Post incrementation to that variable)
        when(todoDao.findAll()).thenReturn(Collections.emptyList(),Collections.singletonList(todoTest)); // I tried to show my database empty
        List<Todo> todoList =todoService.getAllTasks(); //I can see that it goes into if statement in the function when i try to debug but i don't think it's functional.(Check here later)
        Assertions.assertEquals(1,todoList.size());
        Assertions.assertEquals(todoList.get(0),Todo.builder().id(1).build());
    }

    @Test
    public void testUpdateTask() {
    }

}