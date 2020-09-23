package com.kodilla.good.patterns.challenges;

public class OnlineOrderService implements OrderService {

    public boolean executeOrder(final int orderNumber) {
        System.out.println("Executing order: " + orderNumber);
        return true;
    }

}
