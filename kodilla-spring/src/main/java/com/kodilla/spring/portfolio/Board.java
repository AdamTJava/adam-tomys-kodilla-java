package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class Board {

    TaskList toDoList;
    @Autowired
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
