package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public void findFlight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Warszawa", true);
        airports.put("Faro", true);
        airports.put("Lisbona", true);
        airports.put("Katowice", true);
        airports.put("Dubai", true);
        airports.put("Gdańsk", true);
        airports.put("Barcelona", true);
        airports.put("Palermo", true);
        airports.put("Cagliari", true);
        if (airports.containsKey(flight.getDepartureAirport()) && airports.containsKey(flight.getArrivalAirport())){
            System.out.println("This destination is reachable, please chose specific flight.");
        } else {
            throw new RouteNotFoundException("Sorry, we don't provide flights to chosen destination.");
        }
    }

}
