package com.kodilla.good.patterns.food2door;

public interface MailService {

    void sendReceiveOrderEmail(ExampleOrderRequest order);

    void sendPreparedOrderEmail(ExampleOrderRequest order);

    void sendOrderInDelivery(ExampleOrderRequest order);

}
