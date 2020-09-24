package com.kodilla.good.patterns.food2door;

public class ExtraFoodShopMailService implements InformationService {

    public void informClient(Client client, String text) {
        System.out.println("Sending email to " + client.getEmail() + ":\n" + text);
    }

}