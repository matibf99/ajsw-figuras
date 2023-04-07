package com.example.shapesapplication.shapes;

import com.example.shapesapplication.utils.GeometricShapeType;

public class EquilateralTriangle extends GeometricShape {
    public double length;

    public EquilateralTriangle(String color, double length) {
        super(color);
        this.name = GeometricShapeType.EQUILATERAL_TRIANGLE.toString();
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public double area() {
        return Math.sqrt(3) * Math.pow(length, 2) / 4;
    }

    @Override
    public double perimeter() {
        return length * 3;
    }
}
