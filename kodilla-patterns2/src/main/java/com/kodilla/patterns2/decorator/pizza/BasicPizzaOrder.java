package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasicPizzaOrder implements PizzaOrder {

    private List<String> pizza;

    public BasicPizzaOrder() {
        this.pizza = new ArrayList<>();
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15);
    }

    @Override
    public List<String> getIngredients() {
        pizza.add("Medium pizza (thin crust)");
        pizza.add("Tomato sauce");
        return pizza;
    }
}
