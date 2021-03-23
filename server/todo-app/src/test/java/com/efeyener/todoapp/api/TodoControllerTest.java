package com.efeyener.todoapp.api;

import com.efeyener.todoapp.model.Todo;
import com.efeyener.todoapp.service.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static com.sun.deploy.net.HttpRequest.CONTENT_TYPE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//still on progress!!!

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TodoController.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TodoService todoService;

    @Test
    void inputTest() throws Exception {
        //input
        Todo todo = Todo.builder().taskName("task").id(1).status(false).build();
        //when
        ResultActions actions = mockMvc.perform(post("/api/todo").
                contentType(CONTENT_TYPE).content(objectMapper.writeValueAsString(todo)));
        //then
        ArgumentCaptor<Todo> captor =ArgumentCaptor.forClass(Todo.class);
        verify(todoService,times(1)).addTask(captor.capture());
        assertThat(captor.getValue().getTaskName().equals("task"));
        assertThat(captor.getValue().getId()==1);
        assertThat(!captor.getValue().getStatus());
        actions.andExpect(status().isOk());

    }
}