package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {

    private String taskName;
    private String whatToBuy;
    private double quantity;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        System.out.println("Buying " + quantity + " " + whatToBuy);
        TaskFactory factory = new TaskFactory();
        TaskFactory.doneTasks.add(factory.createTask(TaskFactory.SHOPPING));
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        for (int i = 0; i < TaskFactory.doneTasks.size() - 1; i++) {
            if (TaskFactory.doneTasks.get(i).getTaskName().equals("Shopping")) {
                return true;
            }
        }
        return false;
    }
}
