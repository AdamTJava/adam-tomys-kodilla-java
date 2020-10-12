package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.ShapeFactory;

public class PaintingTask implements Task {

    private String taskName;
    private String color;
    private String whatToPaint;
    private boolean isDone = false;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public void executeTask() {
        System.out.println("Painting " + whatToPaint + " in " + color + " color");
        setDone(true);
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if (isDone) {
            return true;
        }
        return false;
    }
}
