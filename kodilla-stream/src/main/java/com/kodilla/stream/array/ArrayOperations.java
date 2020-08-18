package com.kodilla.stream.array;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        Arrays.sort(numbers);
        IntStream.rangeClosed(numbers[0], numbers[numbers.length - 1]).forEach(System.out::println);
        OptionalDouble average = IntStream.rangeClosed(numbers[0], numbers[numbers.length - 1]).average();
        if (average.isPresent()) {
            return average.getAsDouble();
        } else {
            return 0;
        }
    }
}
