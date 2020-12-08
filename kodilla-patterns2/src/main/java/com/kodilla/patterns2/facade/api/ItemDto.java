package com.kodilla.patterns2.facade.api;

public final class ItemDto {
    private final Long ProductId;
    private final double quantity;

    public ItemDto(Long productId, double quantity) {
        ProductId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return ProductId;
    }

    public double getQuantity() {
        return quantity;
    }
}
