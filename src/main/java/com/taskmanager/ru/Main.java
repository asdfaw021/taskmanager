package com.taskmanager.ru;

import java.util.Scanner;

public class Main{

    public static void cleanConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void enter(Scanner in){
        System.out.println("Press enter to continue: ");
        in.nextLine();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        TaskCreator creator = new TaskCreator(in);
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
            System.out.println("4. Save tasks.");
            System.out.println("5. Load tasks.");
            System.out.println("0. Exit.");
            System.out.println("Enter command (0-5): ");
            while(!CValid){
                try {
                    choice = in.nextInt();
                    in.nextLine();
                    if(choice < 0 || choice > 5){
                        System.out.println("Wrong command, try again (0-5).");
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
                    enter(in);
                    break;
                case 2:
                    cleanConsole();
                    System.out.println("Enter the task ID to delete: ");
                    while(!NValid) {
                        try {
                            num = in.nextInt();
                            in.nextLine();
                            taskManager.removeTask(num);
                            NValid = true;
                        } catch (Exception e) {
                            System.out.println("Please enter a number correctly:");
                            in.nextLine();
                        }
                    }
                    enter(in);
                    break;
                case 3:
                    cleanConsole();
                    taskManager.showTasks();
                    enter(in);
                    break;
                case 4:
                    taskManager.saveToFile();
                    enter(in);
                    break;
                case 5:
                    taskManager.loadFromFile();
                    enter(in);
                    break;
                case 0:
                    running = false;
                    break;
            }
        }
        in.close();
    }
}
