package com.efeyener.todoapp.configuration;

import com.efeyener.todoapp.model.Todo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

@Configuration
@EnableCouchbaseRepositories
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {
    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "test";
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getBucketName() {
        return "todoApp";
    }

    /*public void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {
        mapping.mapEntity(Todo.class,getCouchbaseTemplate());

    }
    private CouchbaseTemplate getCouchbaseTemplate(String bucketName) {
        CouchbaseTemplate template = new CouchbaseTemplate(couchbaseClientFactory(bucketName),null);
        return null;
    }
    private CouchbaseClientFactory couchbaseClientFactory(String bucketName){

        return new SimpleCouchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment()),bucketName,this.getScopeName()));
    }
    */


}
