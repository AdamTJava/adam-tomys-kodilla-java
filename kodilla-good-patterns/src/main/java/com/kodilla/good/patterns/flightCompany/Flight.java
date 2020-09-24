package com.kodilla.good.patterns.flightCompany;

public class Flight {

    private final String flightFrom;
    private final String flightTo;

    public Flight(String flightFrom, String flightTo) {
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!flightFrom.equals(flight.flightFrom)) return false;
        return flightTo.equals(flight.flightTo);
    }

    @Override
    public int hashCode() {
        int result = flightFrom.hashCode();
        result = 31 * result + flightTo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return flightFrom + " -> " + flightTo;
    }
}
