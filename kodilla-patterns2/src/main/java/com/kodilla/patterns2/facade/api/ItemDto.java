package com.kodilla.patterns2.facade.api;

public final class ItemDto {
    private final String name;
    private final Long ProductId;
    private final double quantity;

    public ItemDto(String name, Long productId, double quantity) {
        this.name = name;
        ProductId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return ProductId;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return name;
    }
}
