package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class HealthyNewsletter {

    Client client1 = new Client("Adam", "Tomys", "adamtomys@gmail.com", "Bojarskiego 9/4, 41-503 Chorzów");
    private List<Client> newsletter;

    public void addClientToNewsletter() {
        newsletter = new ArrayList<>();
        newsletter.add(client1);
    }

    public List<Client> getNewsletter() {
        return newsletter;
    }

    @Override
    public String toString() {
        return String.valueOf(client1);
    }
}
