package com.kodilla.patterns.factory;

import com.kodilla.patterns.factory.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public final class ShapeFactory {

    public static final String CIRCLE = "CIRCLE";
    public static final String SQUARE = "SQUARE";
    public static final String RECTANGLE = "RECTANGLE";

    public final Shape makeShape(final String shapeClass) {
        switch (shapeClass) {
            case CIRCLE:
                return new Circle("The rounded circle", 4.50);
            case SQUARE:
                return new Square("The angular square", 7.0);
            case RECTANGLE:
                return new Rectangle("The long rectangle", 15.0, 2.50);
            default:
                return null;
        }

    }
}