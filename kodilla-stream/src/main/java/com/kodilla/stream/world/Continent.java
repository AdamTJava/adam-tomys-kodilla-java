package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {

    private final String continentName;
    private final List<Country> listOfCountries;

    public Continent(String continentName) {
        this.continentName = continentName;
        this.listOfCountries = new ArrayList<>();
    }

    public String getContinentName() {
        return continentName;
    }

    public final void addToListOfCountries(Country country) {
        listOfCountries.add(country);
    }

    public List<Country> getListOfCountries() {
        return listOfCountries;
    }
}