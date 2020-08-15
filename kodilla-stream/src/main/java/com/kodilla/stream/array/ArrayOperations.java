package com.kodilla.stream.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        Arrays.sort(numbers);
        IntStream.rangeClosed(numbers[0], numbers[numbers.length - 1]).forEach(System.out::println);
        return IntStream.rangeClosed(numbers[0], numbers[numbers.length - 1]).average().getAsDouble();
    }
}
