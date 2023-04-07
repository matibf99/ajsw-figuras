package com.example.shapesapplication.utils;

import com.example.shapesapplication.shapes.*;

import java.util.Random;

public class GeometricShapeFactory {
    public GeometricShape createShape(GeometricShapeType shapeType, GeometricShapeColor color, int bound) {
        Random random = new Random();

        switch (shapeType) {
            case CIRCLE -> {
                int radius = random.nextInt(bound);
                return new Circle(color.toString(), radius);
            }
            case SQUARE -> {
                int length = random.nextInt(bound);
                return new Square(color.toString(), length);
            }
            case RECTANGLE -> {
                int width = random.nextInt(bound);
                int height = random.nextInt(bound);
                return new Rectangle(color.toString(), width, height);
            }
            case EQUILATERAL_TRIANGLE -> {
                int length = random.nextInt(bound);
                return new EquilateralTriangle(color.toString(), length);
            }
            default -> throw new IllegalArgumentException("Unknown shape");
        }
    }
}
