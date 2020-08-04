package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("Adam");

        String result = simpleUser.getUsername();

        if (result.equals("Adam")) {
            System.out.println("Test OK");
        }else {
            System.out.println("Error");
        }

        Calculator calculator = new Calculator();
        int addResult = calculator.addAToB(2,7);
        int substractResult = calculator.substractBFromA(9,5);

        if (addResult == 9 && substractResult == 4) {
            System.out.println("Test OK");
        }else {
            System.out.println("Error");
        }

    }
}
