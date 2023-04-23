package com.example.shapesapplication.repositories;

import com.example.shapesapplication.models.EquilateralTriangle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquilateralTriangleRepository extends JpaRepository<EquilateralTriangle, Long> {
    @Query("SELECT t FROM EquilateralTriangle t WHERE t.color = :color")
    List<EquilateralTriangle> findAllByColor(String color);
}
