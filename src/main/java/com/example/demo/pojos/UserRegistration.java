package com.example.demo.pojos;

public class UserRegistration {
    private String userId;
    private String password;
    private String passwordConfirmation;
    private String name;

    public UserRegistration() {
    }

    public UserRegistration(String userId, String password, String passwordConfirmation, String name) {
        this.userId = userId;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.name = name;
    }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
