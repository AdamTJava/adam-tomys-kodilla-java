package com.kodilla.good.patterns.flightCompany;

public class Main {
    public static void main(String[] args) {

        FlightsList flightsList = new FlightsList();
        flightsList.createFlightsList();
        FlightFinder flightFinder = new FlightFinder();

        flightFinder.findFlightsFrom("Warsaw");
        System.out.println(" ");
        flightFinder.findFlightsTo("Oslo");
        System.out.println(" ");
        flightFinder.findFlights("Katowice", "Madrid");

    }
}
