package com.taskmanager.ru;

import java.util.ArrayList;
import java.util.Scanner;

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
    public void removeTask(int id, Scanner in){
        if(tasks.isEmpty()){
            System.out.println("The task list is empty");
            return;
        }
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId() == id){
                tasks.remove(i);
                System.out.println("Task with ID " + id + " removed.");
                System.out.println("Press enter to continue: ");
                in.nextLine();
                return;
            }
        }
        System.out.println("Task not found.");
        System.out.println("Press enter to continue: ");
        in.nextLine();
    }
    public void showTasks(){
        if(tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("ID | Name       | Description     | Status     | Difficulty | Deadline   | Created    |");
        for(Task task : tasks){
            String deadlineStr = task.getDeadline() != null ? task.getDeadline().toString() : "None";
            String createdStr = task.getCreated() != null ? task.getCreated().toString() : "None";
            System.out.printf("%2d | %-10s | %-15s | %-11s| %-10s | %-10s | %-10s |%n", task.getId(), task.getName(), task.getDescription(), task.getStatus(), task.getDifficulty(), deadlineStr, createdStr);
        }
    }
}
