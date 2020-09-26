package com.kodilla.good.patterns.food2door;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class GlutenFreeMailService implements MailService {

    private BigDecimal orderValue = new BigDecimal(0);
    private String orderCurrency = null;

    public void sendReceiveOrderEmail(ExampleOrderRequest order) {
        System.out.println("\nHello " + order.getClient().getName() + "!\nWelcome to Gluten Free Shop.\nWe received Your order:");
        GlutenFreeShop.productsInOrder.entrySet().stream()
                .map(entry -> entry.getKey() + ", quantity: " + entry.getValue().intValue() + " " + entry.getKey().getUnit())
                .forEach(System.out::println);

        for (Map.Entry<Product, Double> entry : GlutenFreeShop.productsInOrder.entrySet()) {
            orderValue = orderValue.add((entry.getKey().getPrice()).multiply(BigDecimal.valueOf(entry.getValue())));
            orderCurrency = entry.getKey().getCurrency();
        }
        orderValue = orderValue.setScale(2, RoundingMode.HALF_EVEN);

        System.out.println("Your order value is: " + orderValue + orderCurrency + "\nWE ALREADY RECEIVED YOUR PREPAYMENT and our stuff is preparing products for delivery, stay tuned!");
    }

    public void sendPreparedOrderEmail(ExampleOrderRequest order) {
        System.out.println("\nHello " + order.getClient().getName() + "!\nYour order has been prepared and now is waiting for courier. Stay tuned!");
    }

    public void sendOrderInDelivery(ExampleOrderRequest order) {
        System.out.println("\nHello " + order.getClient().getName() + "!\nCourier has picked up Your package. It will get to You in probably next 24 hours.\nThank You for choosing Gluten Free Shop.");
    }

}
