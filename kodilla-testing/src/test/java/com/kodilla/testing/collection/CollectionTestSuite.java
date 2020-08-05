package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
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
        for (int k = 1; k < 10; k++) {
            numbersList.add(k);
        }
        List<Integer> numberListAfterExtermination = Arrays.asList(2,4,6,8);
        //When
        System.out.println("Extermination method receives list with numbers: "+numbersList+". Should return only 2, 4, 6, 8.");
        OddNumbersExtermination object = new OddNumbersExtermination();
        object.exterminate(numbersList);
        //Then
        Assertions.assertEquals(numberListAfterExtermination, numbersList);
    }

}
