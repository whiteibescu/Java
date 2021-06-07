package com.example.demo.model;

public class User {

    private Long id;
    private String name;
    private Long level;

    public User() {}

    public User(String name, Long level) {
        this.name = name;
        this.level = level;
    }

    public User(Long id, String name, Long level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }
}
