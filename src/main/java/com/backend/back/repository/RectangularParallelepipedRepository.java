package com.backend.back.repository;

import com.backend.back.model.geometry.RectangularParallelepiped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RectangularParallelepipedRepository extends JpaRepository<RectangularParallelepiped, Long> {
}
