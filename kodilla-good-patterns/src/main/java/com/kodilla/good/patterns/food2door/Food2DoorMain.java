package com.kodilla.good.patterns.food2door;

public class Food2DoorMain {
    public static void main(String[] args) {

        ExampleOrderRequest orderRequest = new ExampleOrderRequest();

        OrderProcessor orderProcessor = new OrderProcessor(new ExtraFoodShop());
        OrderProcessor orderProcessor1 = new OrderProcessor(new HealthyShop());
        OrderProcessor orderProcessor2 = new OrderProcessor(new GlutenFreeShop());

        orderProcessor.execute(orderRequest);
        orderProcessor1.execute(orderRequest);
        orderProcessor2.execute(orderRequest);

    }
}
