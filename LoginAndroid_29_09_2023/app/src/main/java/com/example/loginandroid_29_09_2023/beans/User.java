package com.example.loginandroid_29_09_2023.beans;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String username;
    private String password; // Puedes agregar otros campos según tus necesidades

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    // Getters y setters
}
