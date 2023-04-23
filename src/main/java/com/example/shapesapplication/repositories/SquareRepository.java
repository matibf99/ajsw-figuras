package com.example.shapesapplication.repositories;

import com.example.shapesapplication.models.Square;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SquareRepository extends JpaRepository<Square, Long> {
    @Query("SELECT s FROM Square s WHERE s.color = :color")
    List<Square> findAllByColor(String color);
}
