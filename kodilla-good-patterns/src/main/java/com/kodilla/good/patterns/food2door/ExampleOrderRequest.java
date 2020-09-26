package com.kodilla.good.patterns.food2door;

import java.math.BigDecimal;
import java.util.*;

public class ExampleOrderRequest {

    private final Client client;
    private final int orderNumber;
    private Map<Product, Double> shoppingCard;
    Random random = new Random();

    public ExampleOrderRequest() {
        this.client = new Client("Adam", "Tomys", "adamtomys@gmail.com", "Bojarskiego 9/4, 41-503 Chorzów");
        this.orderNumber = random.nextInt(1000) + 1;
        this.shoppingCard = new HashMap<>();
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        HealthyShop healthyShop = new HealthyShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        System.out.println("");
        addToShoppingCard(extraFoodShop.getProductList().get(0), 3);
        addToShoppingCard(extraFoodShop.getProductList().get(0), 99);
        addToShoppingCard(extraFoodShop.getProductList().get(1), 2);
        addToShoppingCard(healthyShop.getProductList().get(0),4);
        addToShoppingCard(healthyShop.getProductList().get(2),3);
        addToShoppingCard(healthyShop.getProductList().get(1),2);
        addToShoppingCard(glutenFreeShop.getProductList().get(0), 5);
        addToShoppingCard(glutenFreeShop.getProductList().get(1), 2);
        System.out.println("\nYour shopping card:");
        shoppingCard.entrySet().stream()
                .map(entry -> entry.getKey() + ", quantity: " + entry.getValue().intValue() + " " + entry.getKey().getUnit() +
                        " (" + entry.getKey().getSupplier() + ")")
                .forEach(System.out::println);
        System.out.println("");

    }

    public void addToShoppingCard(Product product, double productQuantity) {
        double previousProductQuantity;
        if (shoppingCard.containsKey(product)) {
            previousProductQuantity = shoppingCard.get(product);
            if (new BigDecimal(productQuantity + previousProductQuantity).compareTo(product.getAvailableQuantity()) <= 0) {
                shoppingCard.remove(product);
                shoppingCard.put(product, productQuantity + previousProductQuantity);
                double newProductQuantity = productQuantity + previousProductQuantity;
                System.out.println((int)newProductQuantity + " " + product + " has been added to Your shopping card");
            } else {
                System.out.println("You can't add more " + (int)productQuantity + " " + product + ". The Stock is only: " + product.getAvailableQuantity() + ". You already have " +
                        (int)previousProductQuantity + " " + product + " in Your shopping card.");
            }
        } else {
            if (new BigDecimal(productQuantity).compareTo(product.getAvailableQuantity()) <= 0) {
                shoppingCard.put(product, productQuantity);
                System.out.println((int)productQuantity + " " + product + " has been added to Your shopping card.");
            } else {
                System.out.println("There is not enough " + product + " in stock. The stock is only: " + product.getAvailableQuantity());
            }
        }
    }

    public Client getClient() {
        return client;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Map<Product, Double> getShoppingCard() {
        return shoppingCard;
    }

}
