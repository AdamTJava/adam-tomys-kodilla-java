package com.kodilla.good.patterns.food2door;

import java.util.*;

public class ExampleOrderRequest {

    private final Client client;
    private final int orderNumber;
    private Map<Double, Product> shoppingCard;
    Random random = new Random();

    public ExampleOrderRequest() {
        this.client = new Client("Adam", "Tomys", "adamtomys@gmail.com", "Bojarskiego 9/4, 41-503 Chorzów");
        this.orderNumber = random.nextInt(1000) + 1;
        this.shoppingCard = new HashMap<>();
        ExtraFoodShopSupplier extraFoodShop = new ExtraFoodShopSupplier("ExtraFoodShop");
        HealthyShopSupplier healthyShop = new HealthyShopSupplier("HealthyShop");
        addToShoppingCard(extraFoodShop.getProductList().get(0), 3);
        addToShoppingCard(extraFoodShop.getProductList().get(1), 2);
        addToShoppingCard(healthyShop.getProductList().get(0), 5);
        addToShoppingCard(healthyShop.getProductList().get(2), 2);

    }

    public void addToShoppingCard(Product product, double productQuantity) {
            shoppingCard.put(productQuantity, product);
    }

    public Client getClient() {
        return client;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Map<Double, Product> getShoppingCard() {
        return shoppingCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExampleOrderRequest that = (ExampleOrderRequest) o;

        return orderNumber == that.orderNumber;
    }

    @Override
    public int hashCode() {
        return orderNumber;
    }
}
