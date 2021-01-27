package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtraCheeseDecorator extends AbstractPizzaDecorator {

    public ExtraCheeseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(4));
    }

    @Override
    public List<String> getIngredients() {
        List<String> pizza = super.getIngredients();
        pizza.add("Extra cheese");
        return pizza;
    }
}
