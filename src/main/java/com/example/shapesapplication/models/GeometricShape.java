package com.example.shapesapplication.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

@MappedSuperclass
public abstract class GeometricShape implements ShapePerimeter, ShapeArea {
    @Column
    private String color;

    @Transient
    protected String name;

    public GeometricShape() {

    }

    public GeometricShape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }
}
