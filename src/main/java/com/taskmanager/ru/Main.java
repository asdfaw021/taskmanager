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
            int choice = 0;
            int num;
            boolean CValid = false;
            boolean NValid = false;
            System.out.println("Commands:");
            System.out.println("1. Add a task.");
            System.out.println("2. Delete task.");
            System.out.println("3. Show tasks.");
            System.out.println("4. Exit.");
            System.out.println("Enter command (1-4): ");
            while(!CValid){
                try {
                    choice = in.nextInt();
                    in.nextLine();
                    if(choice < 1 || choice > 4){
                        System.out.println("Wrong command, try again (1-4).");
                    }else{
                        CValid = true;
                    }
                } catch (Exception e) {
                    System.out.println("Please enter command correctly:");
                    in.nextLine();
                }
            }
            switch(choice){
                case 1:
                    cleanConsole();
                    taskManager.addTask(creator.createTask());
                    System.out.println("Task added successfully.");
                    System.out.println("Press enter to continue: ");
                    in.nextLine();
                    break;
                case 2:
                    cleanConsole();
                    System.out.println("Enter the task ID to delete: ");
                    while(!NValid) {
                        try {
                            num = in.nextInt();
                            in.nextLine();
                            taskManager.removeTask(num, in);
                            NValid = true;
                        } catch (Exception e) {
                            System.out.println("Please enter a number correctly:");
                            in.nextLine();
                        }
                    }
                    break;
                case 3:
                    cleanConsole();
                    taskManager.showTasks();
                    System.out.println("Press enter to continue: ");
                    in.nextLine();
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
    }
}
