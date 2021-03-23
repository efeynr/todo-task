package com.efeyener.todoapp.dao;

import com.efeyener.todoapp.model.Todo;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Repository("couchbase") //tag the repository to inject the repo to the service(usefull when using multiple repositories)

@Repository
public interface TodoDao extends CouchbaseRepository<Todo, Integer> {

}
