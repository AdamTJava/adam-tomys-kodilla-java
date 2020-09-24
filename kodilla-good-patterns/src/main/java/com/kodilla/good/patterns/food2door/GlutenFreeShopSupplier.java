package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class GlutenFreeShopSupplier implements Supplier {

    private final String name = "GlutenFreeShop";

    public List<Product> createProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(new GlutenFreeShopSupplier(), "Pastas", "Penne", 2, "package", 2.99, "PLN"));
        return productList;
    }

    @Override
    public String toString() {
        return name;
    }

}
