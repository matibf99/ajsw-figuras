package com.example.shapesapplication.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Circle extends GeometricShape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double radius;

    public Circle() {
        this.name = GeometricShapeType.CIRCLE.toString();
    }

    public Circle(String color, double radius) {
        super(color);
        this.name = GeometricShapeType.CIRCLE.toString();
        this.radius = radius;
    }

    public long getId() {
        return id;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
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
