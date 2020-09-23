package com.kodilla.good.patterns.challenges;

import java.util.Random;

public class OrderRequest {

    private final Client client;
    private final Product product;
    private final int orderNumber;
    Random random = new Random();

    public OrderRequest() {
        this.client = new Client("Adam", "adamtomys@gmail.com");
        this.product = new Product("Book", 20);
        this.orderNumber = random.nextInt(1000) + 1;
    }

    public Client getClient() {
        return client;
    }

    public Product getProduct() {
        return product;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderRequest that = (OrderRequest) o;

        return orderNumber == that.orderNumber;
    }

    @Override
    public int hashCode() {
        return orderNumber;
    }
}
