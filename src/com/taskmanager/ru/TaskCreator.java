package com.taskmanager.ru;

import java.util.Scanner;

public class TaskCreator {
    private final Scanner in = new Scanner(System.in);

    public Task createTask(){
        String name, descr;
        int stat;
        System.out.print("Enter task name: ");
        name = in.nextLine();
        while(name.trim().isEmpty()){
            System.out.println("A name can't be empty.");
            System.out.println("Please, try again.");
            System.out.print("Enter task name: ");
            name = in.nextLine();
        }
        Task task = new Task(name);
        System.out.print("\nEnter a task description (or leave blank): ");
        descr = in.nextLine();
        task.setDescription(descr);
        System.out.print("\nEnter the task status (1 - TODO, 2 - IN_PROGRESS, 3 - DONE): ");
        stat = in.nextInt();
        in.nextLine();
        Status st = switch (stat) {
            case 1 -> Status.TODO;
            case 2 -> Status.IN_PROGRESS;
            case 3 -> Status.DONE;
            default -> Status.TODO;
        };
        task.setStatus(st);
        return task;
    }
}
