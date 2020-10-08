package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {

    private String taskName;
    private String where;
    private String using;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        System.out.println("Driving to " + where + " by " + using);
        TaskFactory factory = new TaskFactory();
        TaskFactory.doneTasks.add(factory.createTask(TaskFactory.DRIVING));
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        for (int i = 0; i < TaskFactory.doneTasks.size() - 1; i++) {
            if (TaskFactory.doneTasks.get(i).getTaskName().equals("Driving")) {
                return true;
            }
        }
        return false;
    }
}
