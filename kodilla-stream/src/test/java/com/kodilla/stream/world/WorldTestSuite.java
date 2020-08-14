package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Country poland = new Country("Poland", new BigDecimal("40000000"));
        Country spain = new Country("Span", new BigDecimal("46000000"));
        Country portugal = new Country("Portugal", new BigDecimal("10000000"));
        Country kenya = new Country("Kenya", new BigDecimal("51000000"));
        Country tanzania = new Country("Tanzania", new BigDecimal("56000000"));
        Country maroko = new Country("Maroko", new BigDecimal("36000000"));
        Country thailand = new Country("Thailand", new BigDecimal("70000000"));
        Country japan = new Country("Japan", new BigDecimal("126000000"));
        Country china = new Country("China", new BigDecimal("1400000000"));

        Continent europe = new Continent();
        europe.addToEuropeanCountries(poland);
        europe.addToEuropeanCountries(spain);
        europe.addToEuropeanCountries(portugal);
        Continent africa = new Continent();
        africa.addToAfricanCountries(kenya);
        africa.addToAfricanCountries(tanzania);
        africa.addToAfricanCountries(maroko);
        Continent asia = new Continent();
        asia.addToAsianCountries(thailand);
        asia.addToAsianCountries(japan);
        asia.addToAsianCountries(china);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(asia);

        //When
        BigDecimal expectedValue = new BigDecimal("1835000000");
        BigDecimal actualValue = world.getPeopleQuantity();

        //Then
        Assertions.assertEquals(expectedValue, actualValue);
    }
}
