package com.example.shapesapplication.services;

import com.example.shapesapplication.models.Circle;

import java.util.List;

public interface CircleService {
    void createCircle(Circle circle);
    void updateCircle(Circle circle);
    void deleteCircle(Circle circle);
    void deleteCircleById(long id);
    Circle getCircleById(long id);
    List<Circle> getAllCircles();
    List<Circle> getAllCirclesByColor(String color);
}
