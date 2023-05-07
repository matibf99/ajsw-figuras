package com.example.shapesapplication.models;

public class PrintableShape {
    private final GeometricShape shape;
    private boolean printed;

    public PrintableShape(GeometricShape shape) {
        this.shape = shape;
        this.printed = false;
    }

    public String getColor() {
        return shape.getColor();
    }

    public String getName() {
        return shape.getName();
    }

    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }
}
