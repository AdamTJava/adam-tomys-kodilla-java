package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class PizzaOrderTestSuite {

    @Test
    void testPizzaOrderAdditionalIngredients() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraCheeseDecorator(order);
        order = new ExtraOlivesDecorator(order);
        order = new ExtraShrimpsDecorator(order);

        //When
        List<String> pizza = order.getIngredients();

        //Then
        assertEquals(5, pizza.size());
        pizza.stream()
                .forEach(System.out::println);
    }
}
