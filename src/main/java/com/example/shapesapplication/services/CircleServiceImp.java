package com.example.shapesapplication.services;

import com.example.shapesapplication.repositories.CircleRepository;
import com.example.shapesapplication.models.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircleServiceImp implements CircleService {
    private CircleRepository repository;

    @Autowired
    public CircleServiceImp(CircleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createCircle(Circle circle) {
        repository.save(circle);
    }

    @Override
    public void updateCircle(Circle circle) {
        repository.save(circle);
    }

    @Override
    public void deleteCircle(Circle circle) {
        repository.delete(circle);
    }

    @Override
    public void deleteCircleById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Circle getCircleById(long id) {
        Optional<Circle> result = repository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Circle> getAllCircles() {
        return repository.findAll();
    }

    @Override
    public List<Circle> getAllCirclesByColor(String color) {
        return repository.findAllByColor(color);
    }
}
