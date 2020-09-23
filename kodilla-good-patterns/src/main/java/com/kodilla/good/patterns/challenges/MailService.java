package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {

    public void inform(Client client) {
        System.out.println("Sending email to " + client.getName() + ". Email adress: " + client.getEmail());
    }

}
