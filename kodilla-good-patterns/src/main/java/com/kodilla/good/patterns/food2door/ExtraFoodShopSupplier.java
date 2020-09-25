package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShopSupplier implements Supplier{

    private final String name;
    private List<Product> productList = new ArrayList<>();

    public ExtraFoodShopSupplier(String name) {
        this.name = name;
        createProductList();
    }

    public List<Product> createProductList() {
        productList.add(new Product(  "Tomato", 100, "kg", 5.99, "PLN"));
        productList.add(new Product(  "Potato", 100, "kg", 3.99, "PLN"));
        productList.add(new Product(  "Lettuce", 100, "pieces", 5.99, "PLN"));
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
