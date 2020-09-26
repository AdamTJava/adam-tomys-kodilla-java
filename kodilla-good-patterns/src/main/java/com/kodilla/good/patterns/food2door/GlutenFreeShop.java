package com.kodilla.good.patterns.food2door;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GlutenFreeShop implements Shop {

    private final String name = "GlutenFreeShop";
    private final List<Product> productList = new ArrayList<>();
    public static Map<Product, Double> productsInOrder;
    private final MailService mailService = new GlutenFreeMailService();
    private boolean isPrepared;
    private boolean isSent;
    BigDecimal orderValue = new BigDecimal(0);

    public GlutenFreeShop() {
        createProductList();
    }

    public void createProductList() {
        productList.add(new Product(name, "Gluten free pasta", 100, "pieces", 4.99, "PLN"));
        productList.add(new Product(name, "Gluten free bread", 100, "pieces", 6.99, "PLN"));
        productList.add(new Product(name, "Corn flour", 100, "kg", 2.99, "PLN"));
    }

    public void process(ExampleOrderRequest order) {
        productsInOrder = order.getShoppingCard().entrySet().stream()
                .filter(entry -> entry.getKey().getSupplier().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("\nGLUTEN FREE SHOP PROCESS()");

        if (checkPayment(order)) {
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
            System.out.println("We are waiting for the payment. Order Value is: " + orderValue);
        }

    }

    public boolean checkPayment(ExampleOrderRequest order) {
        System.out.println("Checking payment method");
        GlutenFreeBankAccountOperation bankAccount = new GlutenFreeBankAccountOperation("income", 38.93, "Adam", "Tomys");
        bankAccount.addOperation(bankAccount);

        for (Map.Entry<Product, Double> entry : GlutenFreeShop.productsInOrder.entrySet()) {
            orderValue = orderValue.add((entry.getKey().getPrice()).multiply(BigDecimal.valueOf(entry.getValue())));
        }
        orderValue = orderValue.setScale(2, RoundingMode.HALF_EVEN);
        for (int i = 0; i <= bankAccount.getOperationHistory().size() - 1; i++) {
            if (bankAccount.getOperationHistory().get(i).getOperationType().equals("income") &
                    bankAccount.getOperationHistory().get(i).getName().equals(order.getClient().getName()) &
                    bankAccount.getOperationHistory().get(i).getSurname().equals(order.getClient().getSurname())
            & bankAccount.getOperationHistory().get(i).getAmount().compareTo(orderValue) == 0) {
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
