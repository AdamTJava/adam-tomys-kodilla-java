package com.kodilla.good.patterns.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieStoreTestSuite {

    @Test
    void testGetAllTitlesInLineSeparatedByExclamationMark() {
        //Given
        MovieStore movieStore = new MovieStore();

        //When
        String actualValue = movieStore.getAllTitlesInLineSeparatedByExclamationMark();
        String expectedValue = "{Żelazny Człowiek ! Iron Man ! Mściciele ! Avengers ! Błyskawica ! Flash}";

        //Then
        Assertions.assertEquals(expectedValue, actualValue);
    }

}
