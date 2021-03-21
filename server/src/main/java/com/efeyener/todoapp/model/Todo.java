package com.efeyener.todoapp.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import javax.persistence.*;
import java.util.UUID;

@Document
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id; //
    @Field
    private String taskName;
    @Field
    private Boolean status;

    public Todo(@JsonProperty("id") Integer id, @JsonProperty("name") String taskName, @JsonProperty("status") Boolean status) {
        this.id = id;
        this.taskName = taskName;
        this.status = status;
    }

    public Todo(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public Boolean getStatus() {
        return status;
    }



    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
