package com.backend.back.controller;

import com.backend.back.dto.GeometryProblemDto;
import com.backend.back.dto.SolutionDto;
import com.backend.back.service.GeometryProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private GeometryProblemService geometryProblemService;

    @GetMapping("/solution/user/{userId}")
    public ResponseEntity getProblemSolutionsByUserId(@PathVariable Long userId) {
        List<SolutionDto> solutionList = geometryProblemService.getProblemSolutionsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(solutionList);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity getProblemsByUserId(@PathVariable Long userId) {
        List<GeometryProblemDto> geometryProblemList = geometryProblemService.getProblemsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(geometryProblemList);
    }
}
