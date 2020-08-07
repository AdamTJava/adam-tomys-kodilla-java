package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private Shape shape;
    private List<Shape> shapes = new ArrayList<>();

    public boolean addFigure(Shape shape){
        if (shapes.add(shape)) {
            return true;
        }else {
            return false;
        }
    }

    public boolean removeFigure(Shape shape) {
        if (shapes.remove(shape)) {
            return true;
        } else {
            return false;
        }
    }

    public Shape getFigure(int n){
        Shape calledShape = shapes.get(n);
        return calledShape;
    }

    public String showFigures(){
        String shapesInLine = shapes.get(0).getShapeName();
        for (int i = 1; i < shapes.size(); i++){
            shapesInLine = shapesInLine + ", " + shapes.get(i).getShapeName();
        }
        return shapesInLine;
    }

}
