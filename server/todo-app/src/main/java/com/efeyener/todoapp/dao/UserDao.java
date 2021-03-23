package com.efeyener.todoapp.dao;

import com.efeyener.todoapp.model.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

//@Repository
//Not implemented yet
public interface UserDao extends CouchbaseRepository<User, Integer> {

}
