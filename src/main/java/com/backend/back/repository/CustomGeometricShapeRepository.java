package com.backend.back.repository;

import com.backend.back.model.CustomGeometryShape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomGeometricShapeRepository extends JpaRepository<CustomGeometryShape, Long> {
}
