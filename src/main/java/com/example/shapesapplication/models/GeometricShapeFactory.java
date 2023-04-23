package com.example.shapesapplication.models;

import java.util.Random;

public class GeometricShapeFactory {
    public GeometricShape createShape(GeometricShapeType shapeType, GeometricShapeColor color, int bound) {
        Random random = new Random();

        switch (shapeType) {
            case CIRCLE -> {
                int radius = random.nextInt(bound);
                Circle circle = new Circle();
                circle.setRadius(radius);
                circle.setColor(color.toString());

                return circle;
            }
            case SQUARE -> {
                int length = random.nextInt(bound);
                Square square = new Square();
                square.setLength(length);
                square.setColor(color.toString());

                return square;
            }
            case RECTANGLE -> {
                int width = random.nextInt(bound);
                int height = random.nextInt(bound);
                Rectangle rectangle = new Rectangle();
                rectangle.setWidth(width);
                rectangle.setHeight(height);
                rectangle.setColor(color.toString());

                return rectangle;
            }
            case EQUILATERAL_TRIANGLE -> {
                int length = random.nextInt(bound);
                EquilateralTriangle equilateralTriangle = new EquilateralTriangle();
                equilateralTriangle.setLength(length);
                equilateralTriangle.setColor(color.toString());

                return equilateralTriangle;
            }
            default -> throw new IllegalArgumentException("Unknown shape");
        }
    }
}
