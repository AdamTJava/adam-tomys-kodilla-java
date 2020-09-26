package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HealthyShop implements Shop {

    private final String name = "HealthyFoodShop";
    private final List<Product> productList = new ArrayList<>();
    public static Map<Product, Double> productsInOrder;
    private final MailService mailService = new HealthyMailService();
    private boolean isPrepared;
    private boolean isSent;

    public HealthyShop() {
        createProductList();
    }

    public void createProductList() {
        productList.add(new Product(  name, "Apple", 100, "kg", 3.99, "PLN"));
        productList.add(new Product(  name, "Banana", 100, "kg", 6.99, "PLN"));
        productList.add(new Product(  name, "Watermelon", 100, "pieces", 8.50, "PLN"));
    }

    public void process(ExampleOrderRequest order) {
        productsInOrder = order.getShoppingCard().entrySet().stream()
                .filter(entry -> entry.getKey().getSupplier().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("\nHEALTHY SHOP PROCESS()");
        System.out.println("Verify newsletter method");
        if (verifyNewsletterMembership(order)) {
            mailService.sendReceiveOrderEmail(order);
            sendOrderToWarehouseForPreparationAndPacking();
            if (isPrepared) {
                mailService.sendPreparedOrderEmail(order);
                deliveryPickUp();
                if (isSent) {
                    mailService.sendOrderInDelivery(order);
                }
            }
        } else {
            System.out.println("You have to sign up for our newsletter to make any orders.");
        }
    }

    public boolean verifyNewsletterMembership(ExampleOrderRequest order) {
        HealthyNewsletter healthyNewsletter = new HealthyNewsletter();
        healthyNewsletter.addClientToNewsletter();
        for (Client client : healthyNewsletter.getNewsletter()) {
            if (client.getEmail().equals(order.getClient().getEmail())) {
                return true;
            }
        }
        return false;
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
