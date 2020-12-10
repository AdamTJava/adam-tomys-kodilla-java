package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Student implements Observable {

    private List<Observer> assignedMentors;
    private ArrayDeque<String> tasksQueue;
    private final String name;

    public Student(String name) {
        this.name = name;
        this.assignedMentors = new ArrayList<>();
        this.tasksQueue = new ArrayDeque<>();
    }

    public void addTaskToCheck(String taskName) {
        tasksQueue.offer(taskName);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        assignedMentors.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer mentor : assignedMentors) {
            mentor.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        assignedMentors.remove(observer);
    }

    public ArrayDeque<String> getTasksQueue() {
        return tasksQueue;
    }

    public String getName() {
        return name;
    }
}
