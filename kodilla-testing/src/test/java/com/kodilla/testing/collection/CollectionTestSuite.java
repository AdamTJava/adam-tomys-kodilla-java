package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite Begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite End");
    }

    @BeforeEach
    public void before() {
        System.out.println("Test Case Begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case End");
    }

    @DisplayName("Empty list")

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> numbersList = new ArrayList<>();
        //When
        System.out.println("Extermination method receives empty list and should print: \"The list is empty\"");
        OddNumbersExtermination object = new OddNumbersExtermination();
        object.exterminate(numbersList);
        //Then
        Assertions.assertTrue(numbersList.isEmpty());
    }

    @DisplayName("List of 1-9 numbers")

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(3);
        numbersList.add(4);
        numbersList.add(5);
        numbersList.add(6);
        numbersList.add(7);
        numbersList.add(8);
        numbersList.add(9);
        //When
        System.out.println("Extermination method receives list with 1-9 numbers and should return only 2, 4, 6, 8.");
        OddNumbersExtermination object = new OddNumbersExtermination();
        object.exterminate(numbersList);
        //Then
        Assertions.assertFalse(numbersList.contains(1));
        Assertions.assertFalse(numbersList.contains(3));
        Assertions.assertFalse(numbersList.contains(5));
        Assertions.assertFalse(numbersList.contains(7));
        Assertions.assertFalse(numbersList.contains(9));
    }

}
