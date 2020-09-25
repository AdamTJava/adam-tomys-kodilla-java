package com.kodilla.good.patterns.food2door;

public class OrderProcessor {

    private Supplier supplier;

    public OrderProcessor(Supplier supplier) {
        this.supplier = supplier;
    }

    public void execute(ExampleOrderRequest order) {
        supplier.process();
    }

}
