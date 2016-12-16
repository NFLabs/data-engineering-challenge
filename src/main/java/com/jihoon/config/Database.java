package com.jihoon.config;

import com.google.inject.Inject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Database {

    private String dbServerUrl;
    private String dbServerPort;
    private String username;
    private String password;
    private String databaseName;
    private MongoDatabase database;
    private MongoCollection todoCollection;
    private MongoCollection taskCollection;

    @Inject
    public Database(Configuration config){
        this.dbServerUrl = config.getDbServerUrl();
        this.dbServerPort = config.getDbServerPort();
        this.username = config.getDatabaseUser();
        this.password = config.getDatabasePassword();
        this.databaseName = config.getDatabase();

        init();
    }

    public void init(){
        String mongoUrl = "mongodb://"+getUsername()+":"+getPassword()+"@"+getDbServerUrl()+":"+getDbServerPort()+"/"+getDatabaseName();
        MongoClientURI uri = new MongoClientURI(mongoUrl);
        MongoClient mongoClient = new MongoClient(uri);

        this.database = mongoClient.getDatabase(getDatabaseName());
        this.todoCollection = database.getCollection("todos");
        this.taskCollection = database.getCollection("tasks");

        System.out.println("mongoDB init completed");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getDbServerUrl() {
        return dbServerUrl;
    }

    public void setDbServerUrl(String dbServerUrl) {
        this.dbServerUrl = dbServerUrl;
    }

    public String getDbServerPort() {
        return dbServerPort;
    }

    public void setDbServerPort(String dbServerPort) {
        this.dbServerPort = dbServerPort;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MongoDatabase database) {
        this.database = database;
    }

    public MongoCollection getTodoCollection() {
        return todoCollection;
    }

    public void setTodoCollection(MongoCollection todoCollection) {
        this.todoCollection = todoCollection;
    }

    public MongoCollection getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(MongoCollection taskCollection) {
        this.taskCollection = taskCollection;
    }
}
