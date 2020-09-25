package com.kodilla.good.patterns.food2door;

import java.util.*;

public class ExampleOrderRequest {

    private final Client client;
    private final int orderNumber;
    private Map<Double, Product> shoppingCard;
    Random random = new Random();

    public ExampleOrderRequest() {
        this.client = new Client("Adam", "Tomys", "adamtomys@gmail.com", "Bojarskiego 9/4, 41-503 Chorzów");
        this.orderNumber = random.nextInt(1000) + 1;
        this.shoppingCard = new HashMap<>();
        ExtraFoodShopSupplier extraFoodShop = new ExtraFoodShopSupplier();
        HealthyShopSupplier healthyShop = new HealthyShopSupplier();
        System.out.println("Produkty sklepu ExtraFoodShop: " + extraFoodShop.getProductList());
        System.out.println("Produkty sklepu HealthyShop: " + healthyShop.getProductList());
        addToShoppingCard(3, extraFoodShop.getProductList().get(0));

        addToShoppingCard(4, extraFoodShop.getProductList().get(1)); // program jakby nie widziałe tej lini kodu - nie dodaje produktu do koszyka
        //chociaż wszystko jest dokładnie identycznie w przypadku obydwu dostawców. U drugiego dodaje wszystkie trzy produkty z listy, a u tego pierwszego tylko jeden.
        //niezależnie od tego, czy wpiszę w indexie 0,1, czy 2, po prostu nie działa. Widać to dobrze w system.out.princie. W debuggerze też nic nie widać.
        //Może dasz radę spojrzeć gdzie może być problem ? Przejrzałem wszystko kilka razy.

        addToShoppingCard(5, healthyShop.getProductList().get(0));
        addToShoppingCard(2, healthyShop.getProductList().get(2));
        addToShoppingCard(4, healthyShop.getProductList().get(1));
        System.out.println("Koszyk zakupów (brakuje jednego produktu, którego nie widzi: " + shoppingCard);

    }

    public void addToShoppingCard(double productQuantity, Product product) {
            shoppingCard.put(productQuantity, product);
    }

    public Client getClient() {
        return client;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Map<Double, Product> getShoppingCard() {
        return shoppingCard;
    }

}
