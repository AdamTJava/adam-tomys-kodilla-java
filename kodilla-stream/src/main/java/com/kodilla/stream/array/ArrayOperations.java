package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        IntStream.rangeClosed(numbers[0], numbers[numbers.length - 1]).forEach(System.out::println);
        return IntStream.rangeClosed(numbers[0], numbers[numbers.length - 1]).average().getAsDouble();
    }
}
