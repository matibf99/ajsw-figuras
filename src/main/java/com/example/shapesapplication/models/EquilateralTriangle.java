package com.example.shapesapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EquilateralTriangle extends GeometricShape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double length;

    public EquilateralTriangle() {
        this.name = GeometricShapeType.EQUILATERAL_TRIANGLE.toString();
    }

    public EquilateralTriangle(String color, double length) {
        super(color);
        this.name = GeometricShapeType.EQUILATERAL_TRIANGLE.toString();
        this.length = length;
    }

    public long getId() {
        return id;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
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
