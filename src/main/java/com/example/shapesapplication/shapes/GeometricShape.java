package com.example.shapesapplication.shapes;

public abstract class GeometricShape implements ShapePerimeter, ShapeArea {
    protected String name;
    private final String color;

    public GeometricShape(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
