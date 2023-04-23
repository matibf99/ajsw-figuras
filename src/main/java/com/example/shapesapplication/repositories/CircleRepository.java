package com.example.shapesapplication.repositories;

import com.example.shapesapplication.models.Circle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CircleRepository extends JpaRepository<Circle, Long> {
    @Query("SELECT c FROM Circle c WHERE color = :color")
    List<Circle> findAllByColor(String color);
}
