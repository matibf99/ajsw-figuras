package com.example.shapesapplication.repositories;

import com.example.shapesapplication.models.Rectangle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RectangleRepository extends JpaRepository<Rectangle, Long> {
    List<Rectangle> findAllByColor(String color);
}
