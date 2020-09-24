package com.kodilla.good.patterns.food2door;

import java.util.*;

public class ExampleOrderRequest {

    private final Client client;
    private final int orderNumber;
    private Map<Double, Product> shoppingCard;
    private double orderValue;
    private String orderCurrency;
    Random random = new Random();

    public ExampleOrderRequest() {
        this.client = new Client("Adam", "Tomys", "adamtomys@gmail.com", "Bojarskiego 9/4, 41-503 Chorzów");
        this.orderNumber = random.nextInt(1000) + 1;
        this.shoppingCard = new HashMap<>();
        this.orderValue = 0;
    }

    public void addToShoppingCard(Product product, double productQuantity) {
        if (productQuantity <= product.getAvailableQuantity()) {
            shoppingCard.put(productQuantity, product);
            orderValue = orderValue + (productQuantity * product.getPrice());
            orderCurrency = product.getCurrency();
            System.out.println("Product: " + product.getName() + " from supplier: " + product.getSupplier() +
                    " has been added to shopping card. Quantity: " + productQuantity);
        } else {
            System.out.println("Not enough selected product in stock !");
        }
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public Client getClient() {
        return client;
    }

    public int getOrderNumber() {
        return orderNumber;
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
