package com.mycompany.smartalternativewriting;

public class User {
    private String name;
    private String role; // "Student" or "Researcher"

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

