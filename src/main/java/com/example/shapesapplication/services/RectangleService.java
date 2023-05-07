package com.example.shapesapplication.services;

import com.example.shapesapplication.models.Rectangle;

import java.util.List;

public interface RectangleService {
    void createRectangle(Rectangle rectangle);
    void updateRectangle(Rectangle rectangle);
    void deleteRectangle(Rectangle rectangle);
    void deleteRectangleById(long id);
    Rectangle getRectangleById(long id);
    List<Rectangle> getAllRectangles();
    List<Rectangle> getAllRectanglesByColor(String color);
}
