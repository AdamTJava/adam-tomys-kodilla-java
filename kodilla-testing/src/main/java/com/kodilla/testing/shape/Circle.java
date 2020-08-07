package com.kodilla.testing.shape;

public class Circle implements Shape{

    private String figureName = "Circle";
    private double radius;
    double piNumber = 3.14;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getFigureName() {
        return figureName;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String getShapeName() {
        return figureName;
    }

    @Override
    public double getField() {
        return radius * radius * piNumber ;
    }

    public String toString() {
        return "Shape: "+getShapeName()+", Field: "+getField();
    }
}
