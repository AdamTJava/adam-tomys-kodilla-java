package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShopSupplier implements Supplier{

    private final String name = "ExtraFoodShop";

    public List<Product> createProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(new ExtraFoodShopSupplier(), "Vegetables", "Tomato", 100, "kg", 5.99, "PLN"));
        return productList;
    }

    @Override
    public String toString() {
        return name;
    }
}
