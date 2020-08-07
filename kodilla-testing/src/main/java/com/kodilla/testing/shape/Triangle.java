package com.kodilla.testing.shape;

public class Triangle implements Shape{

    private String figureName = "Triangle";
    private double sideA;
    private double height;

    public Triangle(double sideA, double height) {
        this.sideA = sideA;
        this.height = height;
    }

    public String getFigureName() {
        return figureName;
    }

    public double getSideA() {
        return sideA;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String getShapeName() {
        return figureName;
    }

    @Override
    public double getField() {
        return sideA * height / 2;
    }

    public String toString() {
        return "Shape: "+getShapeName()+", Field: "+getField();
    }
}
