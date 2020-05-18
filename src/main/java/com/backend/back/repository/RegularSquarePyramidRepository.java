package com.backend.back.repository;

import com.backend.back.model.geometry.RegularSquarePyramid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegularSquarePyramidRepository extends JpaRepository<RegularSquarePyramid, Long> {
}
