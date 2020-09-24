package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class HealthyShopSupplier implements Supplier {

    private final String name = "HealthyShop";

    public List<Product> createProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(new HealthyShopSupplier(), "Fruits", "Apple", 300, "kg", 3.99, "PLN"));
        return productList;
    }

    @Override
    public String toString() {
        return name;
    }
}
