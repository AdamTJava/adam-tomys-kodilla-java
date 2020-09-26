package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExtraFoodShop implements Shop {

    private final String name = "ExtraFoodShop";
    private final List<Product> productList = new ArrayList<>();
    public static Map<Product, Double> productsInOrder;
    private final MailService mailService = new ExtraFoodMailService();
    private boolean isPrepared;
    private boolean isSent;

    public ExtraFoodShop() {
        createProductList();
    }

    public void createProductList() {
        productList.add(new Product(name, "Tomato", 100, "kg", 5.99, "PLN"));
        productList.add(new Product(name, "Potato", 100, "kg", 3.99, "PLN"));
        productList.add(new Product(name, "Lettuce", 100, "pieces", 2.99, "PLN"));
    }

    public void process(ExampleOrderRequest order) {
        productsInOrder = order.getShoppingCard().entrySet().stream()
                .filter(entry -> entry.getKey().getSupplier().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("EXTRA FOOD SHOP PROCESS()\n");
        mailService.sendReceiveOrderEmail(order);
        sendOrderToWarehouseForPreparationAndPacking();
        if (isPrepared) {
            mailService.sendPreparedOrderEmail(order);
            deliveryPickUp();
            if (isSent) {
                mailService.sendOrderInDelivery(order);
            }
        }
    }

    public void sendOrderToWarehouseForPreparationAndPacking() {
        System.out.println("\nOrder at the warehouse. Order contains: \n" + productsInOrder);
        setPrepared(true);
    }

    public void deliveryPickUp() {
        //Waiting for delivery pick up
        setSent(true);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setPrepared(boolean prepared) {
        isPrepared = prepared;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    @Override
    public String toString() {
        return name;
    }
}
