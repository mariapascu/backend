package com.backend.back.repository;

import com.backend.back.model.GeometryProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeometryProblemRepository extends JpaRepository<GeometryProblem, Long> {
}
