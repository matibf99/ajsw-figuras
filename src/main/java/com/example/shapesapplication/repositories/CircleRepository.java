package com.example.shapesapplication.repositories;

import com.example.shapesapplication.models.Circle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CircleRepository extends JpaRepository<Circle, Long> {
    List<Circle> findAllByColor(String color);
}
