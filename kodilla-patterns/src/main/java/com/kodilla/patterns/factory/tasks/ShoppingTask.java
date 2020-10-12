package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {

    private String taskName;
    private String whatToBuy;
    private double quantity;
    private boolean isDone = false;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public void executeTask() {
        System.out.println("Buying " + quantity + " " + whatToBuy);
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
