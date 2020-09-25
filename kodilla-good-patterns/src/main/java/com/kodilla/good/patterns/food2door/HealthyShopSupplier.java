package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HealthyShopSupplier implements Supplier {

    private final String name = "HealthyFoodShop";
    private final List<Product> productList = new ArrayList<>();

    public HealthyShopSupplier() {
        createProductList();
    }

    public void createProductList() {
        productList.add(new Product(  name, "Apple", 100, "kg", 3.99, "PLN"));
        productList.add(new Product(  name, "Banana", 100, "kg", 6.99, "PLN"));
        productList.add(new Product(  name, "Watermelon", 100, "pieces", 8.50, "PLN"));
    }

    public void process(ExampleOrderRequest order) {
        Map<Double, Product> productsInOrder = order.getShoppingCard().entrySet().stream()
                .filter(entry -> entry.getValue().getSupplier().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(productsInOrder);
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
