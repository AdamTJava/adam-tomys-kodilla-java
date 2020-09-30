package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations(){
        //Given
        //When
        double resultAdd = calculator.add(2,2);
        double resultSub = calculator.sub(5,2);
        double resultMul = calculator.mul(4, 5);
        double resultDiv = calculator.div(10, 2);
        //Then
        Assertions.assertEquals(4, resultAdd);
        Assertions.assertEquals(3, resultSub);
        Assertions.assertEquals(20, resultMul);
        Assertions.assertEquals(5, resultDiv);
    }

}
