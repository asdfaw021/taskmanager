package com.taskmanager.ru;

import java.time.LocalDate;
import java.util.ArrayList;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TaskManager {
    private ArrayList<Task> tasks;
    private int nextId;
    public static String FILE_PATH = "tasks.json";
    public TaskManager(){
        tasks = new ArrayList<>();
        nextId = 0;
    }
    private Gson getGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        return builder.create();
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
                tasks.remove(i);
                System.out.println("Task with ID " + id + " removed.");
                return;
            }
        }
        System.out.println("Task not found.");
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
    public void saveToFile() {
        Gson gson = getGson();
        String json_tasks = gson.toJson(tasks);
        try{
            FileWriter writer = new FileWriter(FILE_PATH);
            writer.write(json_tasks);
            writer.close();
            System.out.println("Tasks have been successfully saved to "  + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage() + " , please try again");
        }
    }
    public void loadFromFile(){
        Gson gson = getGson();
        try{
            FileReader reader = new FileReader(FILE_PATH);
            tasks = gson.fromJson(reader, new TypeToken<ArrayList<Task>>(){}.getType());
            reader.close();
            if(tasks == null || tasks.isEmpty()){
                nextId = 0;
            }else{
                for(Task task: tasks){
                    if(task.getId() >= nextId){
                        nextId = task.getId() + 1;
                    }
                }
            }
            System.out.println("Tasks have been successfully loaded from  "  + FILE_PATH);
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage() + " , please try again");
        }
    }
}
