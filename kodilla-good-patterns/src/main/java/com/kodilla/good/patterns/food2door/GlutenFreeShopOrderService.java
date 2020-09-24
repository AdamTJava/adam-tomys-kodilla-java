package com.kodilla.good.patterns.food2door;

public class GlutenFreeShopOrderService implements OrderService {

    private boolean isPrepared;
    private boolean isSent;
    private final InformationService informationService;

    public GlutenFreeShopOrderService() {
        this.informationService = new ExtraFoodShopMailService();
    }

    public void setPrepared(boolean prepared) {
        isPrepared = prepared;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    public void sendOrderToWarehouseForPreparationAndPacking(ExampleOrderRequest exampleOrderRequest) {
        System.out.println("Order " + exampleOrderRequest.getOrderNumber() + " is been collecting and packing at the warehouse. \nOrder value: " + exampleOrderRequest.getOrderValue() +
                exampleOrderRequest.getOrderCurrency());
        informationService.informClient(exampleOrderRequest.getClient(), "Order " + exampleOrderRequest.getOrderNumber() + " is been collecting and packing at the warehouse. Order value: " +
                exampleOrderRequest.getOrderValue() + exampleOrderRequest.getOrderCurrency() + ". Stay tuned ! \n");
        setPrepared(true);
    }

    public void sendOrderToClient(ExampleOrderRequest exampleOrderRequest) {
        System.out.println("Courier picked up the order " + exampleOrderRequest.getOrderNumber() + " . It's on is way to client.");
        informationService.informClient(exampleOrderRequest.getClient(), "Courier picked up the order " + exampleOrderRequest.getOrderNumber() +
                ".\nPackage will probably get to You in next 24 hours. \n");
        setSent(true);
    }

    public boolean process(ExampleOrderRequest exampleOrderRequest) {
        sendOrderToWarehouseForPreparationAndPacking(exampleOrderRequest);
        if (isPrepared) {
            sendOrderToClient(exampleOrderRequest);
            if (isSent) {
                System.out.println("Order done.");
                return true;
            }
        }
        return false;
    }

}
