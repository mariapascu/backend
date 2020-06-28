package com.backend.back.repository;

import com.backend.back.model.geometry.GeometricShape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeometricShapeRepository extends JpaRepository<GeometricShape, Long> {
}
