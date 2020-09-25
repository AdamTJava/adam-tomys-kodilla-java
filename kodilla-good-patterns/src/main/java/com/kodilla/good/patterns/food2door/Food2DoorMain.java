package com.kodilla.good.patterns.food2door;

public class Food2DoorMain {
    public static void main(String[] args) {

        ExampleOrderRequest orderRequest = new ExampleOrderRequest();

        OrderProcessor orderProcessor = new OrderProcessor(new ExtraFoodShopSupplier("ExtraFoodShop"));
        OrderProcessor orderProcessor1 = new OrderProcessor(new HealthyShopSupplier("HealthyShop"));

        orderProcessor.execute(orderRequest);
        orderProcessor1.execute(orderRequest);

    }
}
