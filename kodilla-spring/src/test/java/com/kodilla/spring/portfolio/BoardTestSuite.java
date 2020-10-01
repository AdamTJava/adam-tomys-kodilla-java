package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.TaskAdd(board.toDoList, "Task 1 in to do list");
        board.TaskAdd(board.inProgressList, "Task 1 at in progress list");
        board.TaskAdd(board.doneList, "Task 1 in done list list");
        String result1 = board.toDoList.getTasks().get(0);
        String result2 = board.inProgressList.getTasks().get(0);
        String result3 = board.doneList.getTasks().get(0);
        //Then
        Assertions.assertEquals("Task 1 in to do list", result1);
        Assertions.assertEquals("Task 1 at in progress list", result2);
        Assertions.assertEquals("Task 1 in done list list", result3);
    }

}
