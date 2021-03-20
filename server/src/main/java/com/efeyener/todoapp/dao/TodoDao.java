package com.efeyener.todoapp.dao;

import com.efeyener.todoapp.model.Todo;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//@Repository("couchbase")
@Repository("couchbase")

public interface TodoDao extends CouchbaseRepository<Todo,Integer> {
/*

     Todo createTask(Todo todo);

     List<Todo> selectAll(); //to print the database

    Optional<Todo> selectTaskById(Integer id);  //Optional yerine List kullanmayı düşünebilirsin

    int deleteTaskById(Integer id);

    void updateTaskById(int id, Todo todo);
*/
}
