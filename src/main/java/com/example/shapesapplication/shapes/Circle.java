package com.example.shapesapplication.shapes;

import com.example.shapesapplication.utils.GeometricShapeType;

public class Circle extends GeometricShape {
    private final double radius;

    public Circle(String color, double radius) {
        super(color);
        this.name = GeometricShapeType.CIRCLE.toString();
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
