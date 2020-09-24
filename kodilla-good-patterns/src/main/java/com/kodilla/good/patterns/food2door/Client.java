package com.kodilla.good.patterns.food2door;

public class Client {

    private final String name;
    private final String surname;
    private final String email;
    private final String address;

    public Client(String name, String surname, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
