package com.taskmanager.ru;

import java.util.ArrayList;
//import java.util.Collections;

public class TaskManager {
    private ArrayList<Task> tasks;
    private int nextId;

    public TaskManager(){
        tasks = new ArrayList<>();
        nextId = 0;
    }

    public void addTask(Task task){
        task.setId(nextId++);
        tasks.add(task);
    }
    public void removeTask(int id){
        if(tasks.isEmpty()){
            System.out.println("The task list is empty");
            return;
        }
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId() == id){
                tasks.remove(id);
                return;
            }
        }
        System.out.println("Task not found.");
    }
    public void showTasks(){
        System.out.println("ID | Name       | Description     | Status");
        for(Task task : tasks){
            System.out.printf("%2d | %-10s | %-15s | %s%n", task.getId(), task.getName(), task.getDescription(), task.getStatus());
        }
    }
}
