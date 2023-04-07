package com.example.shapesapplication.shapes;

import com.example.shapesapplication.utils.GeometricShapeType;

public class Rectangle extends GeometricShape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.name = GeometricShapeType.RECTANGLE.toString();
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
}
