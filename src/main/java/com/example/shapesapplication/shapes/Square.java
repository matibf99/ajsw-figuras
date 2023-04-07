package com.example.shapesapplication.shapes;

import com.example.shapesapplication.utils.GeometricShapeType;

public class Square extends GeometricShape {
    public double length;

    public Square(String color, double length) {
        super(color);
        this.name = GeometricShapeType.SQUARE.toString();
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double area() {
        return Math.pow(length, 2);
    }

    @Override
    public double perimeter() {
        return 4 * length;
    }
}
