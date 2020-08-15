package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] numbers = new int[]{3, 5, 4};

        //When
        double actualAverage = ArrayOperations.getAverage(numbers);
        double expectedAverage = 4.0;

        //Then
        Assertions.assertEquals(expectedAverage, actualAverage);
    }
}
