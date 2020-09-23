package com.kodilla.good.patterns.challenges;

public class ProductOrderMain {
    public static void main(String[] args) {

        OrderRequest orderRequest = new OrderRequest();

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new OnlineOrderService(), new OnlineOrdersRepository());
        orderProcessor.process(orderRequest);

    }

}
