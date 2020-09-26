package com.kodilla.good.patterns.food2door;

import java.math.BigDecimal;

public class Product {

    private final String supplier;
    private final String name;
    private final BigDecimal availableQuantity;
    private final String unit;
    private final BigDecimal price;
    private final String currency;

    public Product(String supplier, String name, double availableQuantity, String unit, double price, String currency) {
        this.supplier = supplier;
        this.name = name;
        this.availableQuantity = new BigDecimal(availableQuantity);
        this.unit = unit;
        this.price = new BigDecimal(price);
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

    public BigDecimal getAvailableQuantity() {
        return availableQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  name;
    }

}
