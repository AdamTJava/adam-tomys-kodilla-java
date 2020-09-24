package com.kodilla.good.patterns.flightCompany;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightFinder {

    FlightsList flightsList = new FlightsList();

    public void findFlightsFrom(String city) {
        flightsList.createFlightsList().stream()
                .filter(flights -> flights.getFlightFrom() == city)
                .forEach(System.out::println);
    }

    public void findFlightsTo(String city) {
        flightsList.createFlightsList().stream()
                .filter(flight -> flight.getFlightTo() == city)
                .forEach(System.out::println);
    }

    public void findFlights(String from, String to) {

        List<Flight> suitableFlightsFrom = flightsList.createFlightsList().stream()
                .filter(flight -> flight.getFlightFrom() == from)
                .collect(Collectors.toList());

        List<Flight> suitableFlightsTo = flightsList.createFlightsList().stream()
                .filter(flight -> flight.getFlightTo() == to)
                .collect(Collectors.toList());

        Map<Flight, Flight> availableConnections = new HashMap<>();
        for (int i = 0; i <= suitableFlightsFrom.size() - 1; i++) {
            for (int k = 0; k <= suitableFlightsTo.size() - 1; k++) {
                if (suitableFlightsFrom.get(i).getFlightTo() == suitableFlightsTo.get(k).getFlightFrom()) {
                    availableConnections.put(suitableFlightsFrom.get(i), suitableFlightsTo.get(k));
                }
            }
        }

        availableConnections.entrySet().stream()
                .map(entry -> entry.getKey() + " -> " + entry.getValue().getFlightTo())
                .forEach(System.out::println);
    }

}
