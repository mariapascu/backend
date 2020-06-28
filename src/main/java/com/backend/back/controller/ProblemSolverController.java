package com.backend.back.controller;

import com.backend.back.dto.GeometryProblemDto;
import com.backend.back.dto.MultipleGeometryProblemsDto;
import com.backend.back.dto.MultipleSolutionsDto;
import com.backend.back.dto.SolutionDto;
import com.backend.back.exception.CustomException;
import com.backend.back.mapper.GeometryProblemMapper;
import com.backend.back.mapper.SolutionMapper;
import com.backend.back.model.GeometryProblem;
import com.backend.back.service.GeometryProblemService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solver")
public class ProblemSolverController {
    @Autowired
    private GeometryProblemService geometryProblemService;

    @PostMapping("/")
    public ResponseEntity solveProblem(@RequestBody GeometryProblemDto geometryProblemDto) {
        try {
            SolutionDto solutionDto = geometryProblemService.solveProblem(geometryProblemDto);
            return ResponseEntity.status(HttpStatus.OK).body(solutionDto);
        }
        catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PostMapping("/multiple-problems")
    public ResponseEntity solveMultipleProblems(@RequestBody MultipleGeometryProblemsDto geometryProblemsDto) {
        try {
            MultipleSolutionsDto multipleSolutionsDto = geometryProblemService.solveMultipleProblems(geometryProblemsDto);
            return ResponseEntity.status(HttpStatus.OK).body(multipleSolutionsDto);
        }
        catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
