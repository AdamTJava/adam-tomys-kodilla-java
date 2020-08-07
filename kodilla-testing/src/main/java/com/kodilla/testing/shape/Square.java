package com.kodilla.testing.shape;

public class Square implements Shape {

    private String figureName = "Square";
    private double sideA;
    private double sideB;

    public Square(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public String getFigureName() {
        return figureName;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    @Override
    public String getShapeName() {
        return figureName;
    }

    @Override
    public double getField() {
        return sideA * sideB;
    }

    public String toString() {
        return "Shape: "+getShapeName()+", Field: "+getField();
    }
}
