package com.example.shapesapplication.services;

import com.example.shapesapplication.models.EquilateralTriangle;

import java.util.List;

public interface EquilateralTriangleService {
    void createEquilateralTriangle(EquilateralTriangle triangle);
    void updateEquilateralTriangle(EquilateralTriangle triangle);
    void deleteEquilateralTriangle(EquilateralTriangle triangle);
    void deleteEquilateralTriangleById(long id);
    EquilateralTriangle getEquilateralTriangleById(long id);
    List<EquilateralTriangle> getAllEquilateralTriangles();
    List<EquilateralTriangle> getAllEquilateralTrianglesByColor(String color);
}
