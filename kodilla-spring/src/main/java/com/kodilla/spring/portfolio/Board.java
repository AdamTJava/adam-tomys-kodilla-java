package com.kodilla.spring.portfolio;

public class Board {

    TaskList toDoList;
    TaskList inProgressList;
    TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void TaskAdd(TaskList list, String task) {
        list.getTasks().add(task);
    }

    @Override
    public String toString() {
        return "Board: " + toDoList + inProgressList + doneList;
    }
}
