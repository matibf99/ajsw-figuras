package com.example.shapesapplication.services;

import com.example.shapesapplication.repositories.RectangleRepository;
import com.example.shapesapplication.models.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RectangleServiceImp implements RectangleService {
    private RectangleRepository repository;

    @Autowired
    public RectangleServiceImp(RectangleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createRectangle(Rectangle rectangle) {
        repository.save(rectangle);
    }

    @Override
    public void updateRectangle(Rectangle rectangle) {
        repository.save(rectangle);
    }

    @Override
    public void deleteRectangle(Rectangle rectangle) {
        repository.delete(rectangle);
    }

    @Override
    public void deleteRectangleById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Rectangle getRectangleById(long id) {
        Optional<Rectangle> result = repository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Rectangle> getAllRectangles() {
        return repository.findAll();
    }

    @Override
    public List<Rectangle> getAllRectanglesByColor(String color) {
        return repository.findAllByColor(color);
    }
}
