package com.kodilla.good.patterns.flightCompany;

import java.util.ArrayList;
import java.util.List;

public class FlightsList {

    public List<Flight> createFlightsList() {
        List<Flight> flightsList = new ArrayList<>();
        flightsList.add(new Flight("Katowice", "Faro"));
        flightsList.add(new Flight("Faro", "Madrid"));
        flightsList.add(new Flight("Katowice", "Gdansk"));
        flightsList.add(new Flight("Gdansk", "Lisbon"));
        flightsList.add(new Flight("Warsaw", "Berlin"));
        flightsList.add(new Flight("Warsaw", "Colombo"));
        flightsList.add(new Flight("Katowice", "Berlin"));
        flightsList.add(new Flight("Krakow", "Paris"));
        flightsList.add(new Flight("Gdansk", "Porto"));
        flightsList.add(new Flight("Porto", "Oslo"));
        flightsList.add(new Flight("Gdansk", "Reykjavik"));
        flightsList.add(new Flight("Berlin", "Madrid"));
        return flightsList;
    }

}
