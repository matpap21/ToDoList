package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "TASK_TABLE")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_id;
    private String task_name;
    @Column(name = "DONE", columnDefinition = "boolean default false")
    private boolean status = false;


    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Task(int task_id, String task_name, boolean status) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_name='" + task_name + '\'' +
                ", status=" + status +
                '}';
    }
}
