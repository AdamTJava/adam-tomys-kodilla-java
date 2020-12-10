package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.List;

public class Mentor implements Observer {

    private final String name;
    private ArrayDeque<String> notifiedTasks;
    private int tasksToCheckQuantity;

    public Mentor(String name) {
        this.name = name;
        this.notifiedTasks = new ArrayDeque<>();
    }

    @Override
    public void update(Student student) {
        String lastTask = student.getTasksQueue().peekLast();
        notifiedTasks.offer(lastTask);
        tasksToCheckQuantity++;
        System.out.println(getName() + ": new task to check from student: " + student.getName() + "\nTask name: " + lastTask + "\nAll tasks to check: " + tasksToCheckQuantity);
        for (String task : notifiedTasks) {
            System.out.println(task);
        }
    }

    public int getTasksToCheckQuantity() {
        return tasksToCheckQuantity;
    }

    public String getName() {
        return name;
    }
}
