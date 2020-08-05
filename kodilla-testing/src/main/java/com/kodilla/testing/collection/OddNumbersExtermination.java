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
        //Ta metoda działa wyrywkowo ?? Dlaczego
        //for (int i = 0; i < numbers.size(); i++) {
        //    if (numbers.get(i) % 2 != 0) {
        //        numbers.remove(numbers.get(i));
        //    }
        //}
        //return numbers;

        //Ta metoda nie działa w ogóle ?? Dlaczego
        //for (int eachNumber:numbers) {
        //    if (eachNumber % 2 != 0) {
        //        numbers.remove(eachNumber);
        //    }
        //}
        //return numbers;

        //Array.asList() nie działa z removeIf ??? Dlaczego

