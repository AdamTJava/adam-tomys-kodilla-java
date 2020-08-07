package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue()+1);
        }
        return resultMap;
    }

    public double calculateTemperatureAverage() {
        double temperatureAverage;
        double temperatureSum = 0.0;
        for (Map.Entry<String, Double> eachSensor : temperatures.getTemperatures().entrySet()) {
            temperatureSum = temperatureSum + eachSensor.getValue();
        }
        temperatureAverage = temperatureSum / temperatures.getTemperatures().entrySet().size();
        return temperatureAverage;
    }

    public double calculateMiddleValue() {
        double value = 0.0;
        List<Double> tempList = new ArrayList<>();
        for (Map.Entry<String,Double> eachSensor : temperatures.getTemperatures().entrySet()) {
            tempList.add(eachSensor.getValue());
        }
        Collections.sort(tempList);
        if (tempList.size() % 2 == 0) {
                double value1 = tempList.get(tempList.size() / 2 - 1);
                double value2 = tempList.get(tempList.size() / 2);
                double middleValue = (value1 + value2)/2;
                return middleValue;
            }else {
            value = tempList.get(tempList.size()/2);
        }
        return value;
    }

}
