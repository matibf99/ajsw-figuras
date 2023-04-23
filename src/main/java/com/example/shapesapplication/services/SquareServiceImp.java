package com.example.shapesapplication.services;

import com.example.shapesapplication.repositories.SquareRepository;
import com.example.shapesapplication.models.Square;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SquareServiceImp implements SquareService {
    private SquareRepository repository;

    @Autowired
    public SquareServiceImp(SquareRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createSquare(Square square) {
        repository.save(square);
    }

    @Override
    public void updateSquare(Square square) {
        repository.save(square);
    }

    @Override
    public void deleteSquare(Square square) {
        repository.delete(square);
    }

    @Override
    public void deleteSquareById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Square getSquareById(long id) {
        Optional<Square> result = repository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Square> getAllSquares() {
        return repository.findAll();
    }

    @Override
    public List<Square> getAllSquaresByColor(String color) {
        return repository.findAllByColor(color);
    }
}
