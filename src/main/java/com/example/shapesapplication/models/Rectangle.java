package com.example.shapesapplication.models;

import jakarta.persistence.*;

@Entity
public class Rectangle extends GeometricShape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double width;

    @Column
    private double height;

    public Rectangle() {
        this.name = GeometricShapeType.RECTANGLE.toString();
    }

    public Rectangle(String color, double width, double height) {
        super(color);
        this.name = GeometricShapeType.RECTANGLE.toString();
        this.width = width;
        this.height = height;
    }

    public long getId() {
        return id;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
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
