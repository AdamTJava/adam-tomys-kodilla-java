package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class HealthyShopSupplier implements Supplier {

    private final String name;
    private List<Product> productList = new ArrayList<>();

    public HealthyShopSupplier(String name) {
        this.name = name;
        createProductList();
    }

    public List<Product> createProductList() {
        productList.add(new Product(  "Apple", 100, "kg", 3.99, "PLN"));
        productList.add(new Product(  "Banana", 100, "kg", 6.99, "PLN"));
        productList.add(new Product(  "Watermelon", 100, "pieces", 8.50, "PLN"));
        return productList;
    }

    public void process() {
        System.out.println("Processing order");
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
