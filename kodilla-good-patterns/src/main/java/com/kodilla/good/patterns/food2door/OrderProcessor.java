package com.kodilla.good.patterns.food2door;

public class OrderProcessor {

    private final OrderService orderService;

    public OrderProcessor(OrderService orderService) {
        this.orderService = orderService;
    }

    public void execute(final ExampleOrderRequest exampleOrderRequest) {
        orderService.process(exampleOrderRequest);
    }

}
