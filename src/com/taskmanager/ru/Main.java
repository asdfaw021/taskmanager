package com.taskmanager.ru;

import java.util.Scanner;

public class Main{

    public static void cleanConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args){
        TaskManager taskManager = new TaskManager();
        TaskCreator creator = new TaskCreator();
        Scanner in = new Scanner(System.in);
        boolean running = true;
        while(running){
            cleanConsole();
            int choice;
            int num;
            System.out.println("Commands:");
            System.out.println("1. Add a task.");
            System.out.println("2. Delete task.");
            System.out.println("3. Show tasks.");
            System.out.println("4. Exit.");
            System.out.println("Enter command (1-4): ");
            choice = in.nextInt();
            in.nextLine();
            switch(choice){
                case 1:
                    cleanConsole();
                    taskManager.addTask(creator.createTask());
                    break;
                case 2:
                    cleanConsole();
                    System.out.println("Enter the task ID to delete: ");
                    num = in.nextInt();
                    in.nextLine();
                    taskManager.removeTask(num);;
                    break;
                case 3:
                    cleanConsole();
                    taskManager.showTasks();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    cleanConsole();
                    System.out.println("Wrong command, try again (1-4).");
                    break;
            }
        }
    }
}
