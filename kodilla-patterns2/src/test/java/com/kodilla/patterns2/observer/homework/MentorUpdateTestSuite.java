package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MentorUpdateTestSuite {

    @Test
    void testUpdate() {
        //Given
        Student adamTomys = new Student("Adam Tomys");
        Student nataliaTomys = new Student("Natalia Tomys");
        Mentor adrianPazucha = new Mentor("Adrian Pażucha");
        Mentor janKowalski = new Mentor("Jan Kowalski");
        adamTomys.registerObserver(adrianPazucha);
        nataliaTomys.registerObserver(adrianPazucha);
        nataliaTomys.registerObserver(janKowalski);

        //When
        adamTomys.addTaskToCheck("Task1");
        adamTomys.addTaskToCheck("Task2");
        adamTomys.addTaskToCheck("Task3");
        nataliaTomys.addTaskToCheck("Task4");
        nataliaTomys.addTaskToCheck("Task5");
        nataliaTomys.addTaskToCheck("Task6");

        //Then
        Assertions.assertEquals(6, adrianPazucha.getTasksToCheckQuantity());
        Assertions.assertEquals(3, janKowalski.getTasksToCheckQuantity());
    }
}
