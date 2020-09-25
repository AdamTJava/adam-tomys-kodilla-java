package com.kodilla.good.patterns.food2door;

public class Product {

    private final String supplier;
    private final String name;
    private final double availableQuantity;
    private final String unit;
    private final double price;
    private final String currency;

    public Product(String supplier, String name, double availableQuantity, String unit, double price, String currency) {
        this.supplier = supplier;
        this.name = name;
        this.availableQuantity = availableQuantity;
        this.unit = unit;
        this.price = price;
        this.currency = currency;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getUnit() {
        return unit;
    }

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public double getAvailableQuantity() {
        return availableQuantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  name;
    }

}
