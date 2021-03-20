package com.efeyener.todoapp.dao;

import com.efeyener.todoapp.model.Todo;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//@Repository("couchbase")
@Repository

public interface TodoDao extends CouchbaseRepository<Todo,Integer> {

}
