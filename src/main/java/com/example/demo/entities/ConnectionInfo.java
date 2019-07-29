package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConnectionInfo {
    @Id
    @Column(nullable = false)
    private String name; // db name(user friendly)
    @Column(nullable = false)
    private String host; //ipaddress (xxx.xxx.xxx.xxx)
    @Column(nullable = false)
    private String userName; //db login id
    @Column(nullable = false) // db login password
    private String password;

    @Column(nullable = false) // db login password
    private String database;  //db name

    @Column(nullable = false) // db login password
    private String schema;  //db schema name

    public ConnectionInfo() {
    }

    public ConnectionInfo(String name, String host, String userName, String password, String database, String schema) {
        this.name = name;
        this.host = host;
        this.userName = userName;
        this.password = password;
        this.database = database;
        this.schema = schema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
