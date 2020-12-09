package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.List;

public class ExtraShrimpsDecorator extends AbstractPizzaDecorator {
    public ExtraShrimpsDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }

    @Override
    public List<String> getIngredients() {
        List<String> pizza = super.getIngredients();
        pizza.add("Shrimps");
        return pizza;
    }
}
