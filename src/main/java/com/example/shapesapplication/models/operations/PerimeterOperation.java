package com.example.shapesapplication.models.operations;

import com.example.shapesapplication.models.GeometricShape;

import java.util.List;

public class PerimeterOperation {
    public static double perimeter(GeometricShape shape) {
        return shape.perimeter();
    }

    public static double sumPerimeter(List<GeometricShape> shapes) {
        return shapes.stream().mapToDouble(x -> perimeter(x)).sum();
    }
}
