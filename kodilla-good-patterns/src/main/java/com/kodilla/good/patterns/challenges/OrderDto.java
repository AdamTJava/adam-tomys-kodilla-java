package com.kodilla.good.patterns.challenges;

public class OrderDto {

    public Client client;
    public boolean isOrderDone;

    public OrderDto(Client client, boolean isOrderDone) {
        this.client = client;
        this.isOrderDone = isOrderDone;
    }

    public Client getClient() {
        return client;
    }

    public boolean isOrderDone() {
        return isOrderDone;
    }
}
