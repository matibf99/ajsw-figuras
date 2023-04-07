package com.example.shapesapplication;

import com.example.shapesapplication.shapes.*;

import java.util.Arrays;
import java.util.List;

public class OrderShapes {
    public static void main(String... args) {
        List<GeometricShape> shapes = Arrays.asList(
                new Circle("green", 10),
                new Rectangle("red", 1, 1),
                new Square("blue", 2),
                new EquilateralTriangle("orange", 100)
        );

        shapes.sort(((o1, o2) -> (int) (o1.area() - o2.area())));
        shapes.forEach((shape -> System.out.printf("Geometric Shape: %s (%s). Area: %f\n", shape.getName(), shape.getColor(), shape.area())));
    }
}