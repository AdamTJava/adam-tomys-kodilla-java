package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private final InformationService informationService;
    private final OrderService orderService;
    private final OrdersRepository ordersRepository;

    public OrderProcessor(InformationService informationService, OrderService orderService, OrdersRepository ordersRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.ordersRepository = ordersRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrderDone = orderService.executeOrder(orderRequest.getOrderNumber());
        if (isOrderDone) {
            informationService.inform(orderRequest.getClient());
            ordersRepository.addOrder(orderRequest.getOrderNumber());
            return new OrderDto(orderRequest.getClient(), true);
        } else {
            return new OrderDto(orderRequest.getClient(), false);
        }
    }

}
