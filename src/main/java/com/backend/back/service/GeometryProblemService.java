package com.backend.back.service;

import com.backend.back.dto.GeometryProblemDto;
import com.backend.back.dto.MultipleGeometryProblemsDto;
import com.backend.back.dto.MultipleSolutionsDto;
import com.backend.back.dto.SolutionDto;
import com.backend.back.exception.CustomException;

import java.util.List;

public interface GeometryProblemService {
    SolutionDto solveProblem(GeometryProblemDto geometryProblemDto) throws CustomException;
    void saveProblem(GeometryProblemDto geometryProblemDto);
    List<SolutionDto> getProblemSolutionsByUserId(Long userId) throws CustomException;
    List<GeometryProblemDto> getProblemsByUserId(Long userId);
    MultipleSolutionsDto solveMultipleProblems(MultipleGeometryProblemsDto geometryProblemsDto) throws CustomException;
    void deleteProblemById(Long problemId);
}
