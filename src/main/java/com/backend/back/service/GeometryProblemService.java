package com.backend.back.service;

import com.backend.back.dto.GeometryProblemDto;
import com.backend.back.dto.SolutionDto;
import com.backend.back.model.GeometryProblem;

import java.util.List;

public interface GeometryProblemService {
    SolutionDto solveProblem(GeometryProblemDto geometryProblemDto);
    void saveProblem(GeometryProblemDto geometryProblemDto);
    List<SolutionDto> getProblemSolutionsByUserId(Long userId);
    List<GeometryProblemDto> getProblemsByUserId(Long userId);
}
