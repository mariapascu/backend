package com.backend.back.controller;

import com.backend.back.dto.GeometryProblemDto;
import com.backend.back.dto.SolutionDto;
import com.backend.back.mapper.GeometryProblemMapper;
import com.backend.back.mapper.SolutionMapper;
import com.backend.back.model.GeometryProblem;
import com.backend.back.service.GeometryProblemService;
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
        SolutionDto solutionDto = geometryProblemService.solveProblem(geometryProblemDto);
        return ResponseEntity.status(HttpStatus.OK).body(solutionDto);
    }

    @PostMapping("/problem")
    public ResponseEntity saveProblem(@RequestBody GeometryProblemDto geometryProblemDto) {
        geometryProblemService.saveProblem(geometryProblemDto);
        return ResponseEntity.status(HttpStatus.OK).body("Problem Saved");
    }
}
