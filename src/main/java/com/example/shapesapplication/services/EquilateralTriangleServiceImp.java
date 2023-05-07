package com.example.shapesapplication.services;

import com.example.shapesapplication.repositories.EquilateralTriangleRepository;
import com.example.shapesapplication.models.EquilateralTriangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquilateralTriangleServiceImp implements EquilateralTriangleService {
    private EquilateralTriangleRepository repository;

    @Autowired
    public EquilateralTriangleServiceImp(EquilateralTriangleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createEquilateralTriangle(EquilateralTriangle triangle) {
        repository.save(triangle);
    }

    @Override
    public void updateEquilateralTriangle(EquilateralTriangle triangle) {
        repository.save(triangle);
    }

    @Override
    public void deleteEquilateralTriangle(EquilateralTriangle triangle) {
        repository.delete(triangle);
    }

    @Override
    public void deleteEquilateralTriangleById(long id) {
        repository.deleteById(id);
    }

    @Override
    public EquilateralTriangle getEquilateralTriangleById(long id) {
        Optional<EquilateralTriangle> result = repository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<EquilateralTriangle> getAllEquilateralTriangles() {
        return repository.findAll();
    }

    @Override
    public List<EquilateralTriangle> getAllEquilateralTrianglesByColor(String color) {
        return repository.findAllByColor(color);
    }
}
