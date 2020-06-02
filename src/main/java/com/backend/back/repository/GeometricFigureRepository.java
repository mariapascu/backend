package com.backend.back.repository;

import com.backend.back.model.geometry.GeometricFigure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeometricFigureRepository extends JpaRepository<GeometricFigure, Long> {
}
