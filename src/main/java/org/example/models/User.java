package org.example.models;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;
    private String name;
    private String surname;

    @OneToOne
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User(int userId, String name, String surname, Task task) {
        UserId = userId;
        this.name = name;
        this.surname = surname;
        this.task = task;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", task=" + task +
                '}';
    }
}
