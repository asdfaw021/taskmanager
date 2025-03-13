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
    public void removeTask(int number){
        if(tasks.isEmpty()){
            System.out.println("Список пуст");
            return;
        }
        if(number > 0 && number <= tasks.size()){
            tasks.remove(number - 1);
        }else{
            System.out.println("Задача не найдена");
        }

    }
    public void showTasks(){
        System.out.println("ID | Name       | Description     | Status");
        for(Task task : tasks){
            System.out.printf("%2d | %-10s | %-15s | %s%n", task.getId(), task.getName(), task.getDescription(), task.getStatus());
        }
    }
}
