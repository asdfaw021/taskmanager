package com.taskmanager.ru;

public class Main{
    public static void main(String[] args){
        System.out.println("Hello world!");
        TaskManager taskManager = new TaskManager();
        TaskCreator creator = new TaskCreator();
        Task task = creator.createTask();
        Task task1 = creator.createTask();

        Task task2 = creator.createTask();
        Task task3 = creator.createTask();
        taskManager.addTask(task);
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.showTasks();
        taskManager.removeTask(2);
        taskManager.showTasks();
    }
}
