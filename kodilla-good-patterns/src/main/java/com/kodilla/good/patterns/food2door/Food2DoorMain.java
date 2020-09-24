package com.kodilla.good.patterns.food2door;

import java.util.List;

public class Food2DoorMain {
    public static void main(String[] args) {

        ExtraFoodShopSupplier extraFoodShopSupplier = new ExtraFoodShopSupplier();
        HealthyShopSupplier healthyShopSupplier = new HealthyShopSupplier();
        GlutenFreeShopSupplier glutenFreeShopSupplier = new GlutenFreeShopSupplier();

        List<Product> supplier1ProductList = extraFoodShopSupplier.createProductList();
        List<Product> supplier2ProductList = healthyShopSupplier.createProductList();
        List<Product> supplier3ProductList = glutenFreeShopSupplier.createProductList();

        ExampleOrderRequest exampleOrderRequest = new ExampleOrderRequest();
        exampleOrderRequest.addToShoppingCard(supplier1ProductList.get(0), 2);

        ExampleOrderRequest exampleOrderRequest1 = new ExampleOrderRequest();
        exampleOrderRequest.addToShoppingCard(supplier2ProductList.get(0), 3);

        ExampleOrderRequest exampleOrderRequest2 = new ExampleOrderRequest();
        exampleOrderRequest.addToShoppingCard(supplier3ProductList.get(0), 4);

        OrderProcessor orderProcessor = new OrderProcessor(new ExtraFoodShopOrderService());
        OrderProcessor orderProcessor2 = new OrderProcessor(new HealthyShopOrderService());
        OrderProcessor orderProcessor3 = new OrderProcessor(new GlutenFreeShopOrderService());

        orderProcessor.execute(exampleOrderRequest);
        orderProcessor2.execute(exampleOrderRequest1);
        orderProcessor3.execute(exampleOrderRequest2);

    }
}
