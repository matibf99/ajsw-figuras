package com.example.shapesapplication;

import com.example.shapesapplication.models.*;
import com.example.shapesapplication.models.GeometricShapeColor;
import com.example.shapesapplication.models.GeometricShapeFactory;
import com.example.shapesapplication.models.GeometricShapeType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OrderShapes {
    public static void main(String[] args) {
        GeometricShapeFactory factory = new GeometricShapeFactory();
        Random random = new Random();

        List<GeometricShape> shapes = Arrays.asList(
                factory.createShape(GeometricShapeType.CIRCLE, GeometricShapeColor.values()[random.nextInt(GeometricShapeColor.values().length)], 100),
                factory.createShape(GeometricShapeType.EQUILATERAL_TRIANGLE, GeometricShapeColor.values()[random.nextInt(GeometricShapeColor.values().length)], 100),
                factory.createShape(GeometricShapeType.RECTANGLE, GeometricShapeColor.values()[random.nextInt(GeometricShapeColor.values().length)], 100),
                factory.createShape(GeometricShapeType.SQUARE, GeometricShapeColor.values()[random.nextInt(GeometricShapeColor.values().length)], 100)
        );

        shapes.sort(((o1, o2) -> (int) (o1.area() - o2.area())));
        shapes.forEach((shape -> System.out.printf("Geometric Shape: %s (%s). Area: %f\n", shape.getName(), shape.getColor(), shape.area())));
    }
}