package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("TDD Test Suite for shapes")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Preparing tests for shapes:");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Preparing test no. #"+testCounter);
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test no. #"+testCounter+" is finished.");
    }

    @Nested
    @DisplayName("Tests for adding and removing shapes from collection")
    class TestAddAndRemove {

        @Test
        void testAddShape(){
            //Given
            Square square = new Square(5,6);
            Circle circle = new Circle(5);
            Triangle triangle = new Triangle(3,4);
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            boolean result = shapeCollector.addFigure(square);
            boolean result1 = shapeCollector.addFigure(circle);
            boolean result2 = shapeCollector.addFigure(triangle);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertTrue(result1);
            Assertions.assertTrue(result2);
        }

        @Test
        void testRemoveShape() {
            //Given
            Square square = new Square(5,6);
            Circle circle = new Circle(5);
            Triangle triangle = new Triangle(3,4);
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);
            boolean result = shapeCollector.removeFigure(square);
            boolean result1 = shapeCollector.removeFigure(circle);
            boolean result2 = shapeCollector.removeFigure(triangle);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertTrue(result1);
            Assertions.assertTrue(result2);
        }

    }

    @Nested
    @DisplayName("Tests for getting shape's data")
    class TestShapesData {

        @Test
        void testGetFigure() {
            //Given
            Square square = new Square(5,6);
            Circle circle = new Circle(5);
            Triangle triangle = new Triangle(3,4);
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);
            Shape testedShape = shapeCollector.getFigure(0);
            Shape testedShape1 = shapeCollector.getFigure(1);
            Shape testedShape2 = shapeCollector.getFigure(2);
            //Then
            Assertions.assertEquals(testedShape,square);
            Assertions.assertEquals(testedShape1,circle);
            Assertions.assertEquals(testedShape2,triangle);

        }

        @Test
        void testShowFigures() {
            //Given
            Square square = new Square(5,6);
            Circle circle = new Circle(5);
            Triangle triangle = new Triangle(3,4);
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);
            String expectedFiguresNames = shapeCollector.showFigures();
            String figuresNames = square.getFigureName() + ", " + circle.getFigureName()+ ", " + triangle.getFigureName();
            //Then
            Assertions.assertEquals(expectedFiguresNames,figuresNames);
        }

    }
}
