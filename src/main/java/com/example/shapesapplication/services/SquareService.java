package com.example.shapesapplication.services;

import com.example.shapesapplication.models.Square;

import java.util.List;

public interface SquareService {
    void createSquare(Square square);
    void updateSquare(Square square);
    void deleteSquare(Square square);
    void deleteSquareById(long id);
    Square getSquareById(long id);
    List<Square> getAllSquares();
    List<Square> getAllSquaresByColor(String color);
}
