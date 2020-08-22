package com.kodilla.exception.test;

public class FlightFounderMain {
    public static void main(String[] args) {

        Flight katowiceToLisbona = new Flight("Katowice", "Lisbona");
        Flight gdanskToBarcelona = new Flight("Gdańsk", "Barcelona");
        Flight katowiceToColombo = new Flight("Katowice", "Colombo");

        FlightFinder flightFinder = new FlightFinder();

        try {
            flightFinder.findFlight(katowiceToLisbona);
        } catch (RouteNotFoundException exception) {
            System.out.println(exception);
        } finally {
            System.out.println("Thank You for choosing our services.\n");
        }

        try {
            flightFinder.findFlight(gdanskToBarcelona);
        } catch (RouteNotFoundException exception) {
            System.out.println(exception);
        } finally {
            System.out.println("Thank You for choosing our services.\n");
        }

        try {
            flightFinder.findFlight(katowiceToColombo);
        } catch (RouteNotFoundException exception) {
            System.out.println(exception);
        } finally {
            System.out.println("Thank You for choosing our services.");
        }

    }
}
