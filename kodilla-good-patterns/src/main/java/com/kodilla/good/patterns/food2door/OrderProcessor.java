package com.kodilla.good.patterns.food2door;

public class OrderProcessor {

    private Shop shop;

    public OrderProcessor(Shop shop) {
        this.shop = shop;
    }

    public void execute(ExampleOrderRequest order) {
        shop.process(order);
    }

}
