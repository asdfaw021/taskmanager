package com.taskmanager.ru;

import java.util.Scanner;
import java.time.LocalDate;

public class TaskCreator {
    private final Scanner in = new Scanner(System.in);
    private int getIntInput(String prompt, int min, int max){
        System.out.println(prompt);
        boolean valid = false;
        int result = 0;
        while(!valid){
            try{
                result = in.nextInt();
                in.nextLine();
                if(result >= min && result <= max){
                    valid = true;
                }else{
                    System.out.println("Value must be between " + min + " and " + max);
                    System.out.println(prompt);
                    valid = false;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number correctly.");
                in.nextLine();
            }
        }
        return result;
    }
    public Task createTask(){
        String name, descr, ddate, cdate;
        int stat, diff;
        boolean Dvalid = false;
        boolean Cvalid = false;

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

        stat = getIntInput("Enter the task status (1 - TODO, 2 - IN_PROGRESS, 3 - DONE): ", 1, 3);
                Status st = switch (stat) {
                    case 1 -> Status.TODO;
                    case 2 -> Status.IN_PROGRESS;
                    case 3 -> Status.DONE;
                    default -> Status.TODO;
                };
                task.setStatus(st);

        diff = getIntInput("Enter the task difficulty (1 - EASY, 2 - MEDIUM, 3 - HARD): ", 1, 3);
                Difficulty df = switch (diff) {
                    case 1 -> Difficulty.EASY;
                    case 2 -> Difficulty.MEDIUM;
                    case 3 -> Difficulty.HARD;
                    default -> Difficulty.EASY;
                };
                task.setDifficulty(df);


        LocalDate dl = null;
        while(!Dvalid) {
            System.out.print("\nEnter a task deadline (YYYY-MM-DD) or leave blank for none: ");
            ddate = in.nextLine();
            if(ddate.trim().isEmpty()) {
                Dvalid = true;
            }else{
                try{
                    dl = LocalDate.parse(ddate);
                    if(dl.isAfter(LocalDate.now())){
                        Dvalid = true;
                    }
                    else{
                        System.out.println("The deadline date must be later than today's date");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter the deadline date correctly");
                }
            }
        }
        task.setDeadline(dl);

        LocalDate cr = null;
        while(!Cvalid) {
            System.out.print("\nEnter the date the task was created (YYYY-MM-DD) or leave blank for today.: ");
            cdate = in.nextLine();
            if(cdate.trim().isEmpty()) {
                cr = LocalDate.now();
                Cvalid = true;
            }else{
                try{
                    cr = LocalDate.parse(cdate);
                    if(cr.isAfter(LocalDate.now())){
                        System.out.println("The creation date must be today or earlier");
                        Cvalid = false;
                    }else{
                        Cvalid = true;
                    }
                } catch (Exception e) {
                    System.out.println("Please enter the creation date correctly");
                }
            }
        }
        task.setCreated(cr);
        return task;
    }
}
