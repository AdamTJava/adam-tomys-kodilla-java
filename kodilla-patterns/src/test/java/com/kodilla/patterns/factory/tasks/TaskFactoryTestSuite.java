package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskFactoryTestSuite {

    @Test
    void testCreateTaskPainting() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task painting = factory.createTask(TaskFactory.PAINTING);
        painting.executeTask();

        //Then
        Assertions.assertEquals("Painting", painting.getTaskName());
        Assertions.assertEquals("Painting", TaskFactory.doneTasks.get(2).getTaskName());

    }

    @Test
    void testCreateTaskDriving() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task driving = factory.createTask(TaskFactory.DRIVING);
        driving.executeTask();

        //Then
        Assertions.assertEquals("Driving", driving.getTaskName());
        Assertions.assertEquals("Driving", TaskFactory.doneTasks.get(0).getTaskName());
    }

    @Test
    void testCreateTaskShopping() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.createTask(TaskFactory.SHOPPING);
        shopping.executeTask();

        //Then
        Assertions.assertEquals("Shopping", shopping.getTaskName());
        Assertions.assertEquals("Shopping", TaskFactory.doneTasks.get(1).getTaskName());
    }

}
