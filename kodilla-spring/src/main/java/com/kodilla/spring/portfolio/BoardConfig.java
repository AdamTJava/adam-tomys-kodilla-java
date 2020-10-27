package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Qualifier("toDoList")
    @Autowired
    TaskList toDoListDifferentName; // musi być Qualifier, ponieważ pole toDoList z klasy Board ma inną nazwę niż to pole
    // toDoListDifferentName - Spring nie potrafi tego dopasować sam i trzeba mu podać nazwę przez Qualifier. Dodatkowo jest
    //@Autowired, ponieważ w klasie Board tego @Autowired nie ma.

    TaskList inProgressList; // Tutaj nie trzeba nic - pole klasy Board jest identyczne jak tutaj w klasie konfiguracyjnej.
    // Nie trzeba też @Autowired, bo jest dodane w klasie Board. Wystarczy w jednym miejscu, jest to zamienne. Najlepiej
    //ujednolicać dla porządku.

    @Autowired
    TaskList doneList; // Tutaj nazwa pola jest ta sama, więc nie trzeba Qualifiera, ale nie ma w klasie Board adnotacji
    // @Autowired, więc trzeba ją dodać tutaj. Gdzieś musi być, najlepiej wszystko w jednej klasie - konfiguracyjnej

    @Bean(name = "board")
    public Board createBoard() {
        return new Board(toDoListDifferentName, inProgressList, doneList);
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
