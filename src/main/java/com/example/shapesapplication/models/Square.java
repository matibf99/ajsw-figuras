package com.example.shapesapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Square extends GeometricShape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double length;

    public Square() {
        this.name = GeometricShapeType.SQUARE.toString();
    }

    public Square(String color, double length) {
        super(color);
        this.name = GeometricShapeType.SQUARE.name();
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
        return Math.pow(length, 2);
    }

    @Override
    public double perimeter() {
        return 4 * length;
    }
}
