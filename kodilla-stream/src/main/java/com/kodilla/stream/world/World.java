package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {

    private final List<Continent> continentList = new ArrayList<>();

    public final void addContinent(Continent continent) {
        continentList.add(continent);
    }

    public BigDecimal getPeopleQuantity() {

        BigDecimal allPeople = continentList.stream()
                //.filter(continent -> continent.getContinentName() == "Europe") - policzenie liczby ludności tylko dla Europy
                .flatMap(continent -> continent.getListOfCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        return allPeople;
    }
}
