package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {

    private final String continentName;
    private final List<Country> listOfCountries = new ArrayList<>();

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public final void addToListOfCountries(Country country) {
        listOfCountries.add(country);
    }

    public List<Country> getListOfCountries() {
        return listOfCountries;
    }
}