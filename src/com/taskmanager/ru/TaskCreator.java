package com.taskmanager.ru;

import java.util.Scanner;

public class TaskCreator {
    private final Scanner in = new Scanner(System.in);

    public Task createTask(){
        String name, descr;
        int stat, diff;
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
        while(stat < 1 || stat > 3){
            System.out.println("The task status can't be less than one or more than three");
            System.out.println("Please, try again.");
            System.out.println("Enter the task status (1 - TODO, 2 - IN_PROGRESS, 3 - DONE): ");
            stat = in.nextInt();
            in.nextLine();
        }
        Status st = switch (stat) {
            case 1 -> Status.TODO;
            case 2 -> Status.IN_PROGRESS;
            case 3 -> Status.DONE;
            default -> Status.TODO;
        };
        task.setStatus(st);

        System.out.print("\nEnter the task difficulty (1 - EASY, 2 - MEDIUM, 3 - HARD): ");
        diff = in.nextInt();
        in.nextLine();
        while(diff < 1 || diff > 3){
            System.out.println("The difficulty of the task cannot be less than one or more than three");
            System.out.println("Please, try again.");
            System.out.println("Enter the task difficulty (1 - EASY, 2 - MEDIUM, 3 - HARD): ");
            diff = in.nextInt();
            in.nextLine();
        }
        Difficulty df = switch (diff) {
            case 1 -> Difficulty.EASY;
            case 2 -> Difficulty.MEDIUM;
            case 3 -> Difficulty.HARD;
            default -> Difficulty.EASY;
        };
        task.setDifficulty(df);
        return task;
    }
}
