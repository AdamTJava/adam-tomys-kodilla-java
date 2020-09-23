package com.kodilla.good.patterns.challenges;

public class OnlineOrdersRepository implements OrdersRepository{

    public void addOrder(int orderNumber) {
        System.out.println("Adding order: " + orderNumber);
    }

}
