package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {

    private final List<Country> europeanCountries = new ArrayList<>();
    private final List<Country> africanCountries = new ArrayList<>();
    private final List<Country> asianCountries = new ArrayList<>();

    public List<Country> getEuropeanCountries() {
        return europeanCountries;
    }

    public List<Country> getAfricanCountries() {
        return africanCountries;
    }

    public List<Country> getAsianCountries() {
        return asianCountries;
    }

    public final void addToEuropeanCountries(Country country) {
        europeanCountries.add(country);
    }

    public final void addToAfricanCountries(Country country) {
        africanCountries.add(country);
    }

    public final void addToAsianCountries(Country country) {
        asianCountries.add(country);
    }

}
