package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.List;

public class ExtraOlivesDecorator extends AbstractPizzaDecorator {
    public ExtraOlivesDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public List<String> getIngredients() {
        List<String> pizza = super.getIngredients();
        pizza.add("Olives");
        return pizza;
    }
}
