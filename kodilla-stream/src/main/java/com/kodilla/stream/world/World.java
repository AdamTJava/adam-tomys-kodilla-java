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
        BigDecimal allPeople = BigDecimal.ZERO;;

        BigDecimal europeanPopulation = continentList.stream()
                .flatMap(continent -> continent.getEuropeanCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        BigDecimal africanPopulation = continentList.stream()
                .flatMap(continent -> continent.getAfricanCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        BigDecimal asianPopulation = continentList.stream()
                .flatMap(continent -> continent.getAsianCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        allPeople = allPeople.add(europeanPopulation);
        allPeople = allPeople.add(africanPopulation);
        allPeople = allPeople.add(asianPopulation);

        System.out.println(allPeople);
        return allPeople;
    }
}
