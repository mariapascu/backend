package com.backend.back.controller;

import com.backend.back.dto.GeometryProblemDto;
import com.backend.back.dto.SolutionDto;
import com.backend.back.exception.CustomException;
import com.backend.back.service.GeometryProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private GeometryProblemService geometryProblemService;

    @GetMapping("/solution/user/{userId}")
    public ResponseEntity getProblemSolutionsByUserId(@PathVariable Long userId) {
        try {
            List<SolutionDto> solutionList = geometryProblemService.getProblemSolutionsByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK).body(solutionList);
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PostMapping("/")
    public ResponseEntity saveProblem(@RequestBody GeometryProblemDto geometryProblemDto) {
        geometryProblemService.saveProblem(geometryProblemDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity getProblemsByUserId(@PathVariable Long userId) {
        List<GeometryProblemDto> geometryProblemList = geometryProblemService.getProblemsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(geometryProblemList);
    }

    @DeleteMapping("/{problemId}")
    public ResponseEntity deleteProblemById(@PathVariable Long problemId) {
        geometryProblemService.deleteProblemById(problemId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
