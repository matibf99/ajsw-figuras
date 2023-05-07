package com.example.shapesapplication.repositories;

import com.example.shapesapplication.models.Square;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SquareRepository extends JpaRepository<Square, Long> {
    List<Square> findAllByColor(String color);
}
