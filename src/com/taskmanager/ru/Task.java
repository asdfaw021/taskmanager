package com.taskmanager.ru;

import java.time.LocalDate;

public class Task {
    private int id;
    private String name;
    private String description;
    private Status status;
    private Difficulty difficulty;
    private LocalDate deadline;
    private LocalDate created;

    public Task(String name){
        this.name = name;
        this.description = "";
        this.status = Status.TODO;
        this.difficulty = Difficulty.EASY;
        this.deadline = null;
        this.created = LocalDate.now();
    }

    // Setters

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }
    public void setDeadline(LocalDate deadline){
        this.deadline = deadline;
    }
    public void setCreated(LocalDate created){
        this.created = created;
    }

    // Getters
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Status getStatus(){
        return status;
    }
    public Difficulty getDifficulty(){
        return difficulty;
    }
    public LocalDate getDeadline(){
        return deadline;
    }
    public LocalDate getCreated(){
        return created;
    }

    //

    public String toString(){
        String s = "ID: " + id + " Name: " + name + "Description: " + description + " Status: " + status + "\n";
        return s;
    }
}
