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
        assert painting != null;
        painting.executeTask();

        //Then
        Assertions.assertEquals("Painting", painting.getTaskName());

    }

    @Test
    void testCreateTaskDriving() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task driving = factory.createTask(TaskFactory.DRIVING);
        assert driving != null;
        driving.executeTask();

        //Then
        Assertions.assertEquals("Driving", driving.getTaskName());
    }

    @Test
    void testCreateTaskShopping() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.createTask(TaskFactory.SHOPPING);
        assert shopping != null;
        shopping.executeTask();

        //Then
        Assertions.assertEquals("Shopping", shopping.getTaskName());
    }

}
