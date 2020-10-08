package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.ShapeFactory;

public class PaintingTask implements Task {

    private String taskName;
    private String color;
    private String whatToPaint;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        System.out.println("Painting " + whatToPaint + " in " + color + " color");
        TaskFactory factory = new TaskFactory();
        TaskFactory.doneTasks.add(factory.createTask(TaskFactory.PAINTING));
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        for (int i = 0; i < TaskFactory.doneTasks.size() - 1; i++) {
           if (TaskFactory.doneTasks.get(i).getTaskName().equals("Painting")) {
               return true;
           }
        }
        return false;
    }
}
