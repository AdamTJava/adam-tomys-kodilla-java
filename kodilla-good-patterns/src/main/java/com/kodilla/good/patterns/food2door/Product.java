package com.kodilla.good.patterns.food2door;

public class Product {

    private final Supplier supplier;
    private final String category;
    private final String name;
    private double availableQuantity;
    private final String unit;
    private final double price;
    private final String currency;

    public Product(Supplier supplier, String category, String name, double availableQuantity, String unit, double price, String currency) {
        this.supplier = supplier;
        this.category = category;
        this.name = name;
        this.availableQuantity = availableQuantity;
        this.unit = unit;
        this.price = price;
        this.currency = currency;
    }

    public Supplier getSupplier() {
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

}
