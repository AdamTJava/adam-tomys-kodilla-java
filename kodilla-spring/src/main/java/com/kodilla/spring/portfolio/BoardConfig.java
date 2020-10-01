package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDoList")
    TaskList toDoList;
    @Autowired
    @Qualifier("inProgressList")
    TaskList inProgressList;
    @Autowired
    @Qualifier("doneList")
    TaskList doneList;

    @Bean(name = "board")
    public Board createBoard() {
        return new Board(toDoList, inProgressList, doneList);
    }

    @Bean(name = "toDoList")
    public TaskList createToDoTaskList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    public TaskList createInProgressTaskList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    public TaskList createDoneTaskList() {
        return new TaskList();
    }

}
