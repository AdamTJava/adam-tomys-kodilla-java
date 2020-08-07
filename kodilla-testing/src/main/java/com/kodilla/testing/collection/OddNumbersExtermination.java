package com.kodilla.testing.collection;

import java.util.List;

public class OddNumbersExtermination {

    public List<Integer> exterminate(List<Integer> numbers){
        if (numbers.isEmpty()) {
            System.out.println("The list is empty");
        }else {
            numbers.removeIf(number -> number % 2 != 0);
            System.out.println(numbers);
        }
        return numbers;
    }
}

