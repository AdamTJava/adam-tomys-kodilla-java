package com.kodilla.testing.weather;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    @Test
    void testCalculateForecastWithMock() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        //dummy data
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testTemperatureAverage() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        //dummy data
        temperaturesMap.put("Rzeszow", 20.2);
        temperaturesMap.put("Krakow", 29.6);
        temperaturesMap.put("Wroclaw", 36.5);
        temperaturesMap.put("Warszawa", 17.1);
        temperaturesMap.put("Gdansk", 22.3);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //When
        double expectedAverage = (20.2+29.6+36.5+17.1+22.3)/5;
        double receivedAverage = weatherForecast.calculateTemperatureAverage();

        //Then
        Assertions.assertEquals(expectedAverage, receivedAverage);
    }

    @Test
    void testTemperatureMiddleValue() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        //dummy data
        temperaturesMap.put("Rzeszow", 15.0);
        temperaturesMap.put("Krakow", 20.0);
        temperaturesMap.put("Wroclaw", 18.0);
        temperaturesMap.put("Warszawa", 19.0);
        temperaturesMap.put("Gdansk", 22.0);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //When
        double expectedValue = 19.0;
        double receivedAverage = weatherForecast.calculateMiddleValue();

        //Then
        Assertions.assertEquals(expectedValue, receivedAverage);
    }
}